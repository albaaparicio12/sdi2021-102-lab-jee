package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.uniovi.entities.Professor;
import com.uniovi.services.ProfessorService;

@Controller
public class ProfessorsController {
	
	@Autowired //Inyectar el servicio 
	private ProfessorService professorService;

	@RequestMapping("/professor/list") 
	public String getList(Model model){ 
		model.addAttribute("professorList", professorService.getProfessors()); 
		return "professor/list";
		
	}
	
	@RequestMapping(value="/professor/add", method=RequestMethod.POST )
	public String setProfessor(@ModelAttribute Professor professor){ 
		professorService.addProfessor(professor); 
		return "redirect:/professor/list";
	}
	
	@RequestMapping("/professor/details/{id}") 
	public String getDetail(Model model, @PathVariable Long id){ 
		model.addAttribute("professor", professorService.getProfessor(id)); 
		return "professor/details";
	}
	
	@RequestMapping("/professor/delete/{id}") 
	public String deleteProfessor(@PathVariable Long id) {
		professorService.deleteProfessor(id);
		return "redirect:/professor/list";
	}
	
	@RequestMapping(value="/professor/add")
	public String getProfessor(){
		return "professor/add";
	}
	
	@RequestMapping(value="/professor/edit/{id}")
	public String getEdit(Model model, @PathVariable Long id){
		model.addAttribute("professor", professorService.getProfessor(id));
		return "professor/edit";
	}
	
	@RequestMapping(value="/professor/edit/{id}", method=RequestMethod.POST)
	public String setEdit(Model model, @PathVariable Long id, @ModelAttribute Professor professor){
		professor.setId(id);
		professorService.addProfessor(professor);
		return "redirect:/professor/details/"+id;
	}

}
