package bird.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bird.expediter.Expediter;
import bird.model.Cargo;

@Controller
@RequestMapping("/top")
public class TopController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showMenu(ModelMap model) {

		Expediter monitoring = new Expediter();
		
		List<Cargo> active = monitoring.getAllActivaCargoes();
		int allActiveCargoes = active.size();
		
		int mark1 = monitoring.getRatebyMark(1);
		int mark2 = monitoring.getRatebyMark(2);
		int mark3 = monitoring.getRatebyMark(3);
		int mark4 = monitoring.getRatebyMark(4);
		int mark5 = monitoring.getRatebyMark(5);
		
		model.addAttribute("active", active);
		model.addAttribute("allActiveCargoes", allActiveCargoes);
		model.addAttribute("mark1", mark1);
		model.addAttribute("mark2", mark2);
		model.addAttribute("mark3", mark3);
		model.addAttribute("mark4", mark4);
		model.addAttribute("mark5", mark5);
		
		return "Top";

	}

}
