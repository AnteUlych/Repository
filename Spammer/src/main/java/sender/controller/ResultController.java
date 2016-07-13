package sender.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sender.service.EmailService;

@Controller
@RequestMapping("/result")
public class ResultController {

	EmailService service = new EmailService();

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model) {

		List<String> addressBook = service.showAllEmails();
		String result = service.showAllEmailsInOneString(addressBook);

		model.addAttribute("result", result);

		return "result";
	}

}
