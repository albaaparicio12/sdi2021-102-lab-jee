package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.uniovi.entities.Department;
import com.uniovi.services.DepartmentService;
import com.uniovi.validators.DepartmentValidator;

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private DepartmentValidator departmentValidator;

	@RequestMapping("/department/list" )
	public String getListado(Model model){
		model.addAttribute("departmentsList", departmentService.getDepartments());
		return "department/list";
	}

	@RequestMapping(value="/department/add")
	public String getDepartment(Model model){
		model.addAttribute("departmentsList", departmentService.getDepartments());
		return "department/add";
	}
	
	@RequestMapping(value="/department/add", method=RequestMethod.POST )
	public String setDepartment(@Validated Department department, BindingResult result){
		departmentValidator.validate(department,result);
		 if(result.hasErrors())
			 return "department/add";
		 departmentService.addDepartment(department);
		 return "redirect:list";
	}
	
	@RequestMapping(value="/department/add", method=RequestMethod.GET )
	public String setDepartment(Model model){
		model.addAttribute("department", new Department());
		return "department/add";
	}
	
	@RequestMapping("/department/details/{id}" )
	public String getDetail(Model model, @PathVariable Long id){
		model.addAttribute("department", departmentService.getDepartment(id));
		return "department/details";
	}
	
	@RequestMapping("/department/delete/{id}" )
	public String delete(@PathVariable Long id){
		departmentService.deleteDepartment(id);
		return "redirect:/department/list";
	}
	
	@RequestMapping(value="/department/edit/{id}")
	public String getEdit(Model model, @PathVariable Long id){
		model.addAttribute("department", departmentService.getDepartment(id));
		return "department/edit";
	}
	
	@RequestMapping(value="/department/edit/{id}", method=RequestMethod.POST)
	public String setEdit(Model model, @PathVariable Long id, @ModelAttribute Department department){
		department.setId(id);
		departmentService.addDepartment(department);
		return "redirect:/department/details/"+id;
	}
	
	@RequestMapping("/department/list/update")
	public String updateList(Model model){
		model.addAttribute("departmentsList", departmentService.getDepartments()); 
		return "department/list :: tableDepartments";
	}
}
