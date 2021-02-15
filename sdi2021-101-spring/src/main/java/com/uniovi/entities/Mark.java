package com.uniovi.entities;

public class Mark {

	private Long id;
	private String description;
	private Double score;
	
	public Mark(){
		
	}
	
	public Mark(long l, String string, double d) {
		setDescription(string);
		setId(l);
		setScore(d);
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
