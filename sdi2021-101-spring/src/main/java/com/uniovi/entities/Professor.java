package com.uniovi.entities;

import javax.persistence.*;

@Entity
public class Professor{
	
	@Id
	@GeneratedValue
	private long id;
	private String dni;
	private String name;
	private String lastName;
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
		setLastName(surname);
		setCategory(category);
	}
	
	public Professor(String dni, String name, String surname, String category, Department department) {
		super();
		setDni(dni);
		setName(name);
		setLastName(surname);
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
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
		return "Professor [id=" + id + ", dni=" + dni + ", name=" + name + ", surname=" + lastName + ", category="
				+ category + ", department=" + department + "]";
	}

}
