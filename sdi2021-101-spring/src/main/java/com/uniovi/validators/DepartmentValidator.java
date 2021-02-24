package com.uniovi.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.uniovi.entities.Department;

@Component
public class DepartmentValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> aClass) {
		return Department.class.equals(aClass);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		Department department = (Department) target;
		if (department.getDescription().length() < 20) 
			errors.rejectValue("description", "Error.description");		
		if (department.getName().length() < 4 || department.getName().length() > 24) 
			errors.rejectValue("name", "Error.name.length");
		
	}
}