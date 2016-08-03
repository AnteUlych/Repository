package fsmac.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fsmac.model.Form;

public class FormValidator implements Validator {

	private static final int FIRST_QUESTION=1;
	private static final int LAST_QUESTION=10;
	
	public boolean supports(Class<?> paramClass) {
		return Form.class.equals(paramClass);
	}

	public void validate(Object obj, Errors errors) {
		/**
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rate1", "valid.rate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rate2", "valid.rate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rate3", "valid.rate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rate4", "valid.rate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rate5", "valid.rate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rate6", "valid.rate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rate7", "valid.rate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rate8", "valid.rate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rate9", "valid.rate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rate10", "valid.rate");
		*/
		
		for(int index=FIRST_QUESTION; index<=LAST_QUESTION; index++){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rate"+index, "valid.rate");	
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "valid.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "company", "valid.company");
	}
}