package com.transrowi.taller.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Item implements Serializable{

	private static final long serialVersionUID = 5619436403081960104L;
	
	private Integer itemId;
	private Integer familiaId;
	private String 	itemCodigo;
	private String 	descripcion;
	private Integer unidadMedidaId;
	private UnidadMedida unidadMedida;
	private BigDecimal precioLista;
	private BigDecimal costoUnitario;
	private BigDecimal cantidad;
	
	public BigDecimal getCantidad() {
		return cantidad;
	}
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getFamiliaId() {
		return familiaId;
	}
	public void setFamiliaId(Integer familiaId) {
		this.familiaId = familiaId;
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
	public Integer getUnidadMedidaId() {
		return unidadMedidaId;
	}
	public void setUnidadMedidaId(Integer unidadMedidaId) {
		this.unidadMedidaId = unidadMedidaId;
	}
	public BigDecimal getPrecioLista() {
		return precioLista;
	}
	public void setPrecioLista(BigDecimal precioLista) {
		this.precioLista = precioLista;
	}
	public BigDecimal getCostoUnitario() {
		return costoUnitario;
	}
	public void setCostoUnitario(BigDecimal costoUnitario) {
		this.costoUnitario = costoUnitario;
	}
	public UnidadMedida getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public String toString() {
		return getItemId().toString();
	}
}
