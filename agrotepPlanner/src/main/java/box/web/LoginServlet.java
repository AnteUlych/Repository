package box.web;

import java.io.IOException;

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

@Controller
@RequestMapping("/login")
public class LoginServlet {

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model) {
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doPost(HttpServletRequest request,
			HttpServletResponse response) {

		DataBaseController base = new DataBaseController();
		String pass = request.getParameter("pass");

		if (!base.isManagerExisByLoginPass(pass)) {
			base.closeConnection();
			return "login";
		}

		Manager manager = base.getManagersByLoginPass(pass);

		HttpSession session = request.getSession();

		session.setAttribute("id", manager.getId());
		session.setAttribute("status", manager.getStatus());
		session.setAttribute("name", manager.getName());
		
		session.setAttribute("filterMy", Constants.FILTER_FALSE);
		session.setAttribute("filterRemont", Constants.FILTER_FALSE);
		session.setAttribute("filterUrgent", Constants.FILTER_FALSE);
		session.setAttribute("filterNotClosed", Constants.FILTER_FALSE);

		base.closeConnection();

		try {
			response.sendRedirect("/planner/timetable");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "timetable";
	}

}
