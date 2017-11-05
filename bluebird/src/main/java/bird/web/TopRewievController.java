package bird.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bird.expediter.Expediter;
import bird.web.model.Mark;

@Controller
@RequestMapping("/top/allReviews")
public class TopRewievController {

	@RequestMapping(method = RequestMethod.GET)
	public String openReviews(ModelMap model) {

		Expediter monitoring = new Expediter();
		List <Mark> comments = monitoring.getAllComments();
		model.addAttribute("comments", comments);
		
		return "Comments";
	}
}
