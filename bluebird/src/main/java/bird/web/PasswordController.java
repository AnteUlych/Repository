package bird.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bird.expediter.Expediter;
import bird.web.model.Password;

@Controller
@RequestMapping("/")
public class PasswordController {

    @Autowired
    @Qualifier("passwordValidator")
    private Validator validator;
    
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model){
		Password password = new Password();
		model.addAttribute("password", password);
		return "password";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(
		Model model, @Validated Password password, BindingResult result,HttpServletRequest request, HttpServletResponse response) {
		String page = "Hello";

		if(result.hasErrors()) {
			page = "password";
		} else {
			model.addAttribute("password", password);
			
			Expediter dataBase = new Expediter();
			int id = dataBase.getIdOfClientBy(password.getLogin(), password.getPassword());
			String userID = id+"";
			String cargoID = "0";
			HttpSession session = request.getSession();
			session.setAttribute("clientID",userID);
			session.setAttribute("cargoID",cargoID);
			try {
				response.sendRedirect("/bluebird/cabinet");
				//response.sendRedirect("/bluebird/hello");
			} catch (IOException e) {
				e.printStackTrace();
			}
			}		
		return page;
	}

}

