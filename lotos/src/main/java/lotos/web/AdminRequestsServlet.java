package lotos.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lotos.logic.DataController;
import lotos.logic.SimpleLogic;
import lotos.model.Request;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/adminRequests")
public class AdminRequestsServlet {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String cyrex = (String) session.getAttribute("cyrex");
		SimpleLogic logic = new SimpleLogic();
		if(!logic.isPasswordForAdninRight(cyrex)){
			return "adminAccessDenied";
		}
		
		DataController data = new DataController();
		List<Request> requests = data.getAllRequests();
		data.closeConnection();
		
		model.addAttribute("requests", requests);
		
		return "adminRequests";
	}

}
