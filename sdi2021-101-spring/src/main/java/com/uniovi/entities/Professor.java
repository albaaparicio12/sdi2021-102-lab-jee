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
	
	public Professor() {
		
	}
	
	public Professor(String dni, String name, String surname, String category) {
		super();
		setDni(dni);
		setName(name);
		setSurname(surname);
		setCategory(category);
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

	@Override
	public String toString() {
		return "Professor [id=" + id + ", DNI=" + dni + ", name=" + name + ", surname=" + surname + ", category="
				+ category + "]";
	}
	
	

}
