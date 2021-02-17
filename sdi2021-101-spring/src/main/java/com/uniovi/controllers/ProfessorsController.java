package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.Professor;
import com.uniovi.services.ProfessorService;

@RestController
public class ProfessorsController {
	
	@Autowired //Inyectar el servicio 
	private ProfessorService professorService;

	@RequestMapping("/professor/list") 
	public String getList(Model model){ 
		return professorService.getProfessors().toString();
	}
	
	@RequestMapping(value="/professor/add", method=RequestMethod.POST )
	public String setProfessor(@ModelAttribute Professor professor){ 
		professorService.addProfessor(professor); 
		return "Ok";
	}
	
	@RequestMapping("/professor/details/{id}") 
	public String getDetail(Model model, @PathVariable Long id){ 
		return professorService.getProfessor(id).toString();
	}
	
	@RequestMapping("/professor/delete/{id}") 
	public String deleteProfessor(@PathVariable Long id) {
		professorService.deleteProfessor(id);
		 return "Ok";
	}
	


}
