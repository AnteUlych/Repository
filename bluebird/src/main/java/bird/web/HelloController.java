package bird.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bird.expediter.Expediter;



@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping(method = RequestMethod.GET)
	public String showQuote(ModelMap model) {

		Expediter s = new Expediter();
		
        int helloNumber = s.giveAnumber();
     
		model.addAttribute("hello", helloNumber);
		return "Hello";

	}
}
