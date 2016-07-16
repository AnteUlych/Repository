package sender.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sender.domain.Email;

public class EmailValidator implements Validator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public boolean supports(Class<?> paramClass) {
		return Email.class.equals(paramClass);
	}

	public void validate(Object obj, Errors errors) {

		Email email = (Email) obj;
		if (!email.getAddress().matches(EMAIL_PATTERN)) {
			errors.rejectValue("address", "valid.address");
		}

	}
}
