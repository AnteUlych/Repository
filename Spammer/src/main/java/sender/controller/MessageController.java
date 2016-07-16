package sender.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sender.logic.SendMechanism;

@Controller
@RequestMapping("/message")
public class MessageController {

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model) {

		return "message";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doPost(HttpServletResponse res, HttpServletRequest req) {

		String subject = req.getParameter("subject");
		String text = req.getParameter("text");

		SendMechanism mechanism = new SendMechanism(subject, text);
		mechanism.spam();

		return "redirect:result";

	}

}