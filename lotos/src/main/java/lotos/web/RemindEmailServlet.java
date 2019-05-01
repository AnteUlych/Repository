package lotos.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lotos.logic.DataController;
import lotos.logic.MailController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/remind_email")
public class RemindEmailServlet {
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		return "remind_email";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(HttpServletRequest request,
			HttpServletResponse response) {
		
		String mail = request.getParameter("mail");
		DataController data = new DataController();
		
		boolean existingMail = data.isMailExist(mail);
		data.closeConnection();
		
		if(existingMail==true){
			MailController sender = new MailController();
			sender.remindLoginAndPasswordOnMail(mail);
			return "remind_result_true";
		}

		return "remind_result_wrong";
	}
}
