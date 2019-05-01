package lotos.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/panel")
public class PanelServlet {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(HttpServletRequest request, ModelMap model) {
		

		HttpSession session = request.getSession();
		int code = (Integer) session.getAttribute("id");
		
		model.addAttribute("id", code);
		
		return "panel";
	}

}
