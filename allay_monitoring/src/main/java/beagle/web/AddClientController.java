package beagle.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/addClient")
public class AddClientController {

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model) {
		
		
		
		
		return "addClient";
	}

}
