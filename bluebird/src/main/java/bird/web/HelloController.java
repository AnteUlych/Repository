package bird.web;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping(method = RequestMethod.GET)
	public String showQuote(ModelMap model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		//session.setAttribute("cargoID","8");
		String var1 = (String) session.getAttribute("clientID");
		String var2 = (String) session.getAttribute("cargoID");
		model.addAttribute("hello", var1);
		model.addAttribute("var2", var2);
		return "Hello";

	}
}
