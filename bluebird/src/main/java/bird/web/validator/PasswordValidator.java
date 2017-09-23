package bird.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import bird.expediter.Expediter;
import bird.web.model.Password;

public class PasswordValidator implements Validator {

	public boolean supports(Class<?> paramClass) {
		return Password.class.equals(paramClass);
	}

	public void validate(Object obj, Errors errors) {
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "valid.login");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "valid.login");
		
		Password incoming = (Password) obj;
		
		String login = incoming.getLogin();
		String password = incoming.getPassword();
		
		Expediter user = new Expediter();
		
		if (!user.isAccountExist(login, password)) {
			errors.rejectValue("password", "valid.password");
		}
	}
}