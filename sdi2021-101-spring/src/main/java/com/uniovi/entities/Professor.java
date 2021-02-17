package com.uniovi.entities;

import javax.persistence.*;

@Entity
public class Professor {
	
	@Id
	@GeneratedValue
	private Long id;
	private String DNI;
	private String name;
	private String surname;
	private String category;
	
	public Professor() {
		
	}
	
	public Professor(String dni, String name, String surname, String category, Long id) {
		super();
		setDNI(dni);
		setName(name);
		setSurname(surname);
		setCategory(category);
		setId(id);
	}
	
	public String getDNI() {
		return DNI;
	}
	
	private void setDNI(String dNI) {
		DNI = dNI;
	}
	
	public String getName() {
		return name;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	private void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getCategory() {
		return category;
	}
	
	private void setCategory(String category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", DNI=" + DNI + ", name=" + name + ", surname=" + surname + ", category="
				+ category + "]";
	}
	
	

}
