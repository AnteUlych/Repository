package lotos.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lotos.logic.DataController;
import lotos.logic.SimpleLogic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/adminlogin")
public class AdminLoginServlet {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		return "adminlogin";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(HttpServletRequest request,
			HttpServletResponse response) {
		
		String cyrex = request.getParameter("cyrex");
		
		SimpleLogic logic = new SimpleLogic();
		
		if(logic.isPasswordForAdninRight(cyrex)){
			
			HttpSession session = request.getSession();
			session.setAttribute("cyrex", cyrex);
			
			try {
				response.sendRedirect("/lotos/adminRequests");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return "adminRequests";
		}
		
		return "adminAccessDenied";
	}

}
