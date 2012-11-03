package com.transrowi.taller.web.catalogo.form;

import java.util.List;

import com.transrowi.taller.domain.UnidadMedida;

public class FormItem{
	
	private int itemId;
	private int familiaId;
	private String itemCodigo;
	private String descripcion;
	private int unidadMedidaId;
	private List<UnidadMedida> unidadMedidaList;
	private String precioLista;
	
	
	
	public String getPrecioLista() {
		return precioLista;
	}
	public void setPrecioLista(String precioLista) {
		this.precioLista = precioLista;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getFamiliaId() {
		return familiaId;
	}
	public void setFamiliaId(int famliaId) {
		this.familiaId = famliaId;
	}
	public String getItemCodigo() {
		return itemCodigo;
	}
	public void setItemCodigo(String itemCodigo) {
		this.itemCodigo = itemCodigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getUnidadMedidaId() {
		return unidadMedidaId;
	}
	public void setUnidadMedidaId(int unidadMedidaId) {
		this.unidadMedidaId = unidadMedidaId;
	}
	public List<UnidadMedida> getUnidadMedidaList() {
		return unidadMedidaList;
	}
	public void setUnidadMedidaList(List<UnidadMedida> unidadMedidaList) {
		this.unidadMedidaList = unidadMedidaList;
	}
	
}
