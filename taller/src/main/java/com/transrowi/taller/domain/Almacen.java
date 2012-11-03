package com.transrowi.taller.domain;

import java.io.Serializable;

public class Almacen implements Serializable{

	private static final long serialVersionUID = 1575929784616929151L;
	
	private Integer almacenId;
	private String descripcion;
	public Integer getAlmacenId() {
		return almacenId;
	}
	public void setAlmacenId(Integer almacenId) {
		this.almacenId = almacenId;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String toString() {
		return getAlmacenId().toString();
	}

}
