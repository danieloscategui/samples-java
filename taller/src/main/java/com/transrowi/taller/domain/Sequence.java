package com.transrowi.taller.domain;

import java.io.Serializable;

public class Sequence implements Serializable{
	
	private static final long serialVersionUID = 386813297719167668L;

	private String nombre;
	private Long nextId;
	
	public Sequence() {
	}
	
	public Sequence(String nombre, Long nextId) {
		this.nombre = nombre;
		this.nextId = nextId;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getNextId() {
		return nextId;
	}
	public void setNextId(Long nextId) {
		this.nextId = nextId;
	}
}
