package beagle.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/bird")
public class BirdController {

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model) {
		
		
		
		
		return "bird";
	}
}
