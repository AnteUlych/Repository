package bird.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bird.expediter.Expediter;
import bird.model.Visitor;


@Controller
@RequestMapping("/top/allVisitors")
public class TopVisitorsController {

	@RequestMapping(method = RequestMethod.GET)
	public String openVisitors(ModelMap model) {

		Expediter monitoring = new Expediter();
		List <Visitor> visitors = monitoring.getAllVisitors();
		model.addAttribute("visitors", visitors);
		
		return "Visitors";
	}
	
}
