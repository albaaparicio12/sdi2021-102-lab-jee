package com.uniovi.validators;
import com.uniovi.entities.Professor;
import com.uniovi.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;

@Component
public class ProfessorValidator implements Validator{
	
	@Autowired
	private ProfessorService professorService;
	
	@Override
	public boolean supports(Class<?> aClass) {
		return Professor.class.equals(aClass);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		Professor professor = (Professor) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "Error.empty");
		if (!isDniCorrect(professor.getDni())) {
			errors.rejectValue("dni", "Error.signup.dni.length");
		}
		if (professorService.getProfessorByDni(professor.getDni()) != null) {
			errors.rejectValue("dni", "Error.signup.dni.duplicate");
		}
		if (professor.getName().length() < 4 || professor.getName().length() > 24) {
			errors.rejectValue("name", "Error.signup.name.length");
		}
		if (professor.getLastName().length() < 5 || professor.getLastName().length() > 24) {
			errors.rejectValue("lastName", "Error.signup.lastName.length");
		}
		if (professor.getCategory().length() < 5 || professor.getCategory().length() > 24) {
			errors.rejectValue("category", "Error.signup.category.length");
		}
	}
	
	private boolean isDniCorrect(String dni) {
		return (dni.length() == 9 && ultimoCaracterEsLetra(dni));
	}
	
	private boolean ultimoCaracterEsLetra (String dni) {
		String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz";
		String ultimoCaracter = String.valueOf(dni.charAt(dni.length()-1)); 
		return(letras.contains(ultimoCaracter));			
	}

}
