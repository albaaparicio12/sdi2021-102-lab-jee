package com.uniovi.entities;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name= "user")
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	@Column(unique=true)
	private String dni;
	
	private String name;
	private String lastName;
	private String role;	
	private String password;
	
	@Transient
	private String passwordConfirm;	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Mark> marks;

	public User() {
		
	}
	
	public User(long id, String dni, String name, String lastName, String role, Set<Mark> marks) {
		super();
		this.id = id;
		this.dni = dni;
		this.name = name;
		this.lastName = lastName;
		this.role = role;
		this.marks = marks;
	}

	public User(String dni, String name, String lastname) {
		this.dni = dni;
		this.name = name;
		this.lastName = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Mark> getMarks() {
		return marks;
	}

	public void setMarks(Set<Mark> marks) {
		this.marks = marks;
	}
	
}
