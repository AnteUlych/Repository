package fsmac.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fsmac.model.Rate;

public class RateValidator implements Validator {

		public boolean supports(Class<?> paramClass) {
			return Rate.class.equals(paramClass);
		}

		public void validate(Object obj, Errors errors) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tonns", "valid.tonns");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "m3", "valid.m3");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pol", "valid.pol");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "destination", "valid.destination");
		}
}