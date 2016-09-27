package com.mum.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mum.model.Schedule;

@Component
public class DateValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Schedule.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors e) {
		Schedule scdule = (Schedule) arg0;
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "startDate", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "endDate", "field.required");
        if (scdule.getStartDate().compareTo(scdule.getEndDate())>0) {
        	e.rejectValue("validDate","", "Start date should be less than endDate");
        } 
        
		
	}


}
