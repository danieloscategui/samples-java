package com.transrowi.taller.domain;

import java.io.Serializable;

public class Familia implements Serializable{

	private static final long serialVersionUID = 1212531981470111345L;
	
	private Integer familiaId;
	private Integer grupoId;
	private String 	familiaCodigo;
	private String 	descripcion;
	public Integer getFamiliaId() {
		return familiaId;
	}
	public void setFamiliaId(Integer familiaId) {
		this.familiaId = familiaId;
	}
	public Integer getGrupoId() {
		return grupoId;
	}
	public void setGrupoId(Integer grupoId) {
		this.grupoId = grupoId;
	}
	public String getFamiliaCodigo() {
		return familiaCodigo;
	}
	public void setFamiliaCodigo(String familiaCodigo) {
		this.familiaCodigo = familiaCodigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String toString() {
		return getFamiliaId().toString();
	}
}
