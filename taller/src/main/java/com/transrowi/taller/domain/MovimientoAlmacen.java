package com.transrowi.taller.domain;

import java.io.Serializable;
import java.util.Date;

public class MovimientoAlmacen implements Serializable{

	private static final long serialVersionUID = 7450325227954044060L;
	
	private Long movimientoId;
	private Integer almacenId;
	private Almacen almacen;
	private Date fechaMovimiento;
	private int tipoMovimiento;
	private Long correlativo;
	
	public Long getMovimientoId() {
		return movimientoId;
	}
	public void setMovimientoId(Long movimientoId) {
		this.movimientoId = movimientoId;
	}
	public Integer getAlmacenId() {
		return almacenId;
	}
	public void setAlmacenId(Integer almacenId) {
		this.almacenId = almacenId;
	}
	public Almacen getAlmacen() {
		return almacen;
	}
	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}
	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}
	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}
	public int getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(int tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	public Long getCorrelativo() {
		return correlativo;
	}
	public void setCorrelativo(Long correlativo) {
		this.correlativo = correlativo;
	}
	@Override
	public String toString() {
		return getMovimientoId().toString();
	}
}
