package com.uniovi.entities;

import javax.persistence.*;

@Entity
public class Mark {

	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private Double score;
	private Boolean resend = false;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Mark(){
		
	}
	
	public Mark(long l, String string, double d) {
		super();
		setDescription(string);
		setId(l);
		setScore(d);
	}
	
	public Mark(String string, double d, User user) {
		super();
		setDescription(string);
		setScore(d);
		setUser(user);
	}

	public Boolean getResend() {
		return resend;
	}

	public void setResend(Boolean resend) {
		this.resend = resend;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	
	public Double getScore() {
		return score;
	}
	
	public void setScore(Double score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Mark [id=" + id + ", description=" + description + ", score=" + score + "]";
	}
}
