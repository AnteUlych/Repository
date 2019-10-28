package box.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		
		String code = request.getParameter("code");
		
		if (!base.isCodeOfManagerExist(code)) {
			base.closeConnection();
			return "login";
		}
		
		Manager manager = base.getManagersByCode(code);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("id", manager.getId());
		session.setAttribute("rank", manager.getRank());
		session.setAttribute("name", manager.getCode());
				
		base.closeConnection();
		
		try {
			response.sendRedirect("/bazaar/auction");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "login";
	}

}
