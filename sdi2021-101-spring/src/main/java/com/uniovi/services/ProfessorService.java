package com.uniovi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.uniovi.entities.Professor;
import com.uniovi.repositories.ProfessorsRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorsRepository professorsRepository;
	
	public Page<Professor> getProfessors(Pageable pageable){
		Page<Professor> professors = professorsRepository.findAll(pageable);
		return professors;
	}
	
	public Professor getProfessor(Long id){
		return professorsRepository.findById(id).get();
	}
	
	public void addProfessor(Professor professor){
		// Si en Id es null le asignamos el ultimo + 1 de la lista
		professorsRepository.save(professor);
	}
	
	public void deleteProfessor(Long id){
		professorsRepository.deleteById(id);
	}
	
	public Professor getProfessorByDni(String dni) {
		return professorsRepository.findByDni(dni);
	}

}
