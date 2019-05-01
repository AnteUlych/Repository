package lotos.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class TestServlet {
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		return "test";
	}
}
