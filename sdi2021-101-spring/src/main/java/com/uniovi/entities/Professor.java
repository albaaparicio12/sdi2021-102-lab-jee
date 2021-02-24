package com.uniovi.entities;

import javax.persistence.*;

@Entity
public class Professor {
	
	@Id
	@GeneratedValue
	private Long id;
	private String dni;
	private String name;
	private String surname;
	private String category;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
	public Professor() {
		
	}
	
	public Professor(String dni, String name, String surname, String category) {
		super();
		setDni(dni);
		setName(name);
		setSurname(surname);
		setCategory(category);
	}
	
	public Professor(String dni, String name, String surname, String category, Department department) {
		super();
		setDni(dni);
		setName(name);
		setSurname(surname);
		setCategory(category);
		setDepartment(department);
	}
	
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dNI) {
		this.dni = dNI;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", dni=" + dni + ", name=" + name + ", surname=" + surname + ", category="
				+ category + ", department=" + department + "]";
	}

}
