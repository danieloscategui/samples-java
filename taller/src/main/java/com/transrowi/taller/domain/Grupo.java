package com.transrowi.taller.domain;

import java.io.Serializable;

public class Grupo implements Serializable {

	private static final long serialVersionUID = 3270811550672831715L;
	
	private Integer grupoId;
	private String  grupoCodigo;
	private String	descripcion;

	public Integer getGrupoId() {
		return grupoId;
	}
	public void setGrupoId(Integer grupoId) {
		this.grupoId = grupoId;
	}
	public String getGrupoCodigo() {
		return grupoCodigo;
	}
	public void setGrupoCodigo(String grupoCodigo) {
		this.grupoCodigo = grupoCodigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String toString() {
		return getGrupoId().toString();
	}
}
