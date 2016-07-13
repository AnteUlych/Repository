package sender.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sender.domain.Email;
import sender.service.EmailService;


@Controller
@RequestMapping("/email")
public class EmailController {

	EmailService service = new EmailService();
	
    @Autowired
    @Qualifier("emailValidator")
    private Validator validator;
    
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model){
		Email email = new Email();
		model.addAttribute("email", email);
		
		
		List <String> addressBook = service.showAllEmails();
		model.addAttribute("addressBook", addressBook);
		
		return "email";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(
		Model model, @Validated Email email, BindingResult result, HttpServletRequest req) {
	
		String page = "email";
		String redirect = "redirect:";
		List <String> addressBook = service.showAllEmails();
		model.addAttribute("addressBook", addressBook);
		
		if (req.getParameter("delete") != null){
			String address = req.getParameter("notUseful");
			service.deleteByAddress(address);
			page = redirect;
		}
			
		if(!result.hasErrors()) {
			String newAddress = req.getParameter("address");
			try{
			service.addEmail(newAddress); 
			}catch(JpaSystemException e){
				return redirect;
			}
			page = redirect;
		}	
		return page;
	}

}
