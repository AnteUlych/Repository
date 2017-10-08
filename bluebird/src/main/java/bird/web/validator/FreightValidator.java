package bird.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import bird.web.model.Freight;

public class FreightValidator implements Validator {

	public boolean supports(Class<?> paramClass) {
		return Freight.class.equals(paramClass);
	}

	public void validate(Object obj, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "client", "valid.client");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "valid.description");
	
	}
}