package com.uniovi.entities;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "department")
public class Department {

	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private String name;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private Set<Professor> professors;
	
	public Department() {
		
	}
	
	public Department(Long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(Set<Professor> professors) {
		this.professors = professors;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
