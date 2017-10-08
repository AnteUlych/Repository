package bird.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bird.expediter.Expediter;
import bird.web.model.Customer;
import bird.web.model.Freight;

@Controller
@RequestMapping("/addClient")
public class AddClientController {

	@Autowired
	@Qualifier("customerValidator")
	private Validator validator;
	

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);

		return "addClient";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(Model model, @Validated Customer customer,
			BindingResult result, HttpServletResponse response) {
		model.addAttribute("customer", customer);
		String returnVal = "Console";
		if (result.hasErrors()) {
			returnVal = "addClient";
		} else {
			model.addAttribute("customer", customer);
			
			Expediter monitoring = new Expediter();
			monitoring.addClient(customer.getCompany(), customer.getName(),
					customer.getEmail(), customer.getPhone(),
					customer.getLogin(), customer.getPassword());
			
			returnVal = "ok"; //fix redirect or united it
			
		}
		return returnVal;
	}
}
