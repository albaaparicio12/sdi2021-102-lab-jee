package com.uniovi.validators;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;

import com.uniovi.entities.Mark;

@Component
public class MarkValidator implements Validator {
		
	@Override
	public boolean supports(Class<?> aClass) {
		return Mark.class.equals(aClass);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		Mark mark = (Mark) target;
		if (mark.getDescription().length() < 20) {
			errors.rejectValue("description", "Error.addMark.description");
		}
		if (mark.getScore()<0 || mark.getScore()>10) {
			errors.rejectValue("score", "Error.addMark.score");
		}
	}
}