package fsmac.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fsmac.model.Questionnaire;
import fsmac.service.QuestionnaireService;


@Controller
@RequestMapping("/admin.htm")
public class AdminController {
	@RequestMapping(method = RequestMethod.GET)
	public String openForm(Model model) {
		
		QuestionnaireService qs = new QuestionnaireService();
		List<Questionnaire> questionnaire =qs.getAllQuestionnaires();
		List<String> totalRates =qs.getTotalRates();
		
		model.addAttribute("questionnaire", questionnaire);
		model.addAttribute("totalRates", totalRates);
		
		return "admin";
	}
}
