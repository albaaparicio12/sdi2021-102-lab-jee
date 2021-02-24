package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.uniovi.entities.Mark;
import com.uniovi.services.MarkService;
import com.uniovi.services.UsersService;
import com.uniovi.validators.MarkValidator;

@Controller
public class MarksControllers {
	
	@Autowired //Inyectar el servicio 
	private MarkService marksService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private MarkValidator markValidator;

	@RequestMapping("/mark/list") 
	public String getList(Model model){ 
		model.addAttribute("markList",marksService.getMarks());
		return "mark/list"; 
		}
	
	@RequestMapping(value="/mark/add", method=RequestMethod.POST )
	public String setMark(@Validated Mark mark, Model model, BindingResult result){ 
		markValidator.validate(mark, result);
		model.addAttribute("usersList", usersService.getUsers());
		if(result.hasErrors()) {
			return"/mark/add";
		}
		marksService.addMark(mark);		
		return "redirect:/mark/list";
	}
	
	@RequestMapping(value="/mark/add", method=RequestMethod.GET )
	public String setMark(Model model){ 
		model.addAttribute("mark", new Mark());
		model.addAttribute("usersList", usersService.getUsers());
		return "mark/add";
	}

	
	@RequestMapping("/mark/details/{id}") 
	public String getDetail(Model model, @PathVariable Long id){ 
		model.addAttribute("mark", marksService.getMark(id)); 
		return "mark/details";
	}
	
	@RequestMapping("/mark/delete/{id}") 
	public String deleteMark(@PathVariable Long id) {
		 marksService.deleteMark(id);
		 return "redirect:/mark/list";
	}
		
	@RequestMapping(value="/mark/edit/{id}")
	public String getEdit(Model model, @PathVariable Long id){
		model.addAttribute("mark", marksService.getMark(id));
		model.addAttribute("usersList", usersService.getUsers());
		return "mark/edit";
	}
	
	@RequestMapping(value="/mark/edit/{id}", method=RequestMethod.POST)
	public String setEdit(Model model, @PathVariable Long id, @ModelAttribute Mark mark){
		Mark original = marksService.getMark(id);
		// modificar solo score y description
		original.setScore(mark.getScore());
		original.setDescription(mark.getDescription());
		marksService.addMark(original);
		return "redirect:/mark/details/"+id;
	}
	
	@RequestMapping("/mark/list/update")
	public String updateList(Model model){
		model.addAttribute("markList", marksService.getMarks() );
		return "mark/list :: tableMarks";
	}
}
