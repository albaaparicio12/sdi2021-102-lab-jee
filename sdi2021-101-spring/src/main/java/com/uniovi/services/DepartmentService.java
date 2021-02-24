package com.uniovi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uniovi.entities.Department;
import com.uniovi.repositories.DepartmentsRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentsRepository departmentsRepository;
	
	public List<Department> getDepartments() {
		List<Department> departments = new ArrayList<Department>();
		departmentsRepository.findAll().forEach(departments::add);
		return departments;
	}
	
	public Department getDepartment(Long id) {
		return departmentsRepository. findById(id).get();
	}
	
	public void addDepartment(Department user) {
		departmentsRepository.save(user);
	}
	
	public Optional<Department> getDepartmentById(Long id) {
		return departmentsRepository.findById(id);
	}
	
	public void deleteDepartment(Long id) {
		departmentsRepository.deleteById(id);
	}
}
