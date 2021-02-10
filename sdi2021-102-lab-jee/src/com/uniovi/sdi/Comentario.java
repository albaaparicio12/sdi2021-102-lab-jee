package com.uniovi.sdi;

public class Comentario {
	String texto;
	String usuario;
	
	public Comentario() {
		
	}
	public Comentario(String txt, String usu) {
		setTexto(txt);
		setUsuario(usu);
	}
	
	
	public String getTexto() {
		return texto;
	}
	private void setTexto(String texto) {
		this.texto = texto;
	}
	public String getUsuario() {
		return usuario;
	}
	private void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
