package bird.web.validator;

import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import bird.expediter.Expediter;
import bird.web.model.Customer;

public class CustomerValidator implements Validator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public boolean supports(Class<?> paramClass) {
		return Customer.class.equals(paramClass);
	}

	public void validate(Object obj, Errors errors) {
		
		Customer client = (Customer) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "company", "valid.company");
		if(!client.getEmail().matches(EMAIL_PATTERN)) {
			errors.rejectValue("email","valid.email");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "valid.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "valid.phone");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "valid.login");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "valid.password");
		
		Expediter monitoring = new Expediter();
		List<String> clients = monitoring.getListofClients();
		if(clients.contains(client.getCompany())) {
			errors.rejectValue("company", "valid.company");
		}
	}
}
