package box.web;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.Constants;
import box.logic.DataBaseController;
import box.model.Manager;
import box.model.Weeklyreminder;

@Controller
@RequestMapping("/login")
public class LoginServlet {
	
	Constants constants =new Constants();
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model) {
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(HttpServletRequest request,
			HttpServletResponse response) {
		
		DataBaseController base = new DataBaseController();
		String code = request.getParameter("code");
		
		if(!base.isManagerExisByCode(code)){
			base.closeConnection();
			return "login";			
		}
		
		Manager manager = base.getManagersByCode(code);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("id", manager.getId());
		session.setAttribute("rank", manager.getRank());
		session.setAttribute("name", manager.getName());
		
		List <Weeklyreminder> managerreminders =base.getListOfWeeklyreminderByManagerId(manager.getId());
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		int todayDayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		
		for(Weeklyreminder r:managerreminders) {
			if(r.getDayofweek()!=todayDayOfWeek) {
			    base.editWeeklyreminderCheckById(r.getId(), constants.UNCHECKED_WEEKLYREMINDER);
			}
		}
		
		base.closeConnection();
		
		try {
				response.sendRedirect("/clientshisory/plan");			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "login";
	}

}
