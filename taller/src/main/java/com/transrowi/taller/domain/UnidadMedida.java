package com.transrowi.taller.domain;

import java.io.Serializable;

public class UnidadMedida implements Serializable{

	private static final long serialVersionUID = -7780879997973769995L;

	private Integer unidadMedidaId;
	private String 	descripcion;
	private String  acronimo;
	
	public Integer getUnidadMedidaId() {
		return unidadMedidaId;
	}
	public void setUnidadMedidaId(Integer unidadMedidaId) {
		this.unidadMedidaId = unidadMedidaId;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAcronimo() {
		return acronimo;
	}
	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}
	

}
