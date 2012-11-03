package com.transrowi.taller.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class MovimientoAlmacenItem implements Serializable{

	private static final long serialVersionUID = -5810381013165286778L;
	
	private Long movimientoId;
	private Integer itemId;
	private Item item;
	private Integer unidadMedidaId;
	private UnidadMedida unidadMedida;
	private BigDecimal cantidadMovimiento;
	private BigDecimal costoUnitario;
	private BigDecimal total;
	
	public Long getMovimientoId() {
		return movimientoId;
	}
	public void setMovimientoId(Long movimientoId) {
		this.movimientoId = movimientoId;
	}
	public Integer getItemid() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public UnidadMedida getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public BigDecimal getCantidadMovimiento() {
		return cantidadMovimiento;
	}
	public void setCantidadMovimiento(BigDecimal cantidadMovimiento) {
		this.cantidadMovimiento = cantidadMovimiento;
	}
	public BigDecimal getCostoUnitario() {
		return costoUnitario;
	}
	public void setCostoUnitario(BigDecimal costoUnitario) {
		this.costoUnitario = costoUnitario;
	}
	public BigDecimal getTotal() {
		return total;
	}
	
	public Integer getUnidadMedidaId() {
		return unidadMedidaId;
	}
	public void setUnidadMedidaId(Integer unidadMedidaId) {
		this.unidadMedidaId = unidadMedidaId;
	}
	public void calcularTotal() {
		if (cantidadMovimiento != null && costoUnitario != null){
			total = cantidadMovimiento.multiply(costoUnitario);
		}else{
			total = null;
		}
	}
}
