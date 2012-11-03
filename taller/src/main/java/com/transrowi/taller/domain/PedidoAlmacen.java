package com.transrowi.taller.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PedidoAlmacen implements Serializable{

	private static final long serialVersionUID = 3483553677870397849L;
	
	private Long pedidoId;
	private Date fechaPedido;
	private String solicitadoPor;
	private Date fechaAutorizacion;
	private String autorizadoPor;
	private Date fechaAtencion;
	private String atendidoPor;
	private String estado;
	private String observacion;
	private List<PedidoAlmacenItem> pedidoAlmacenItems = new ArrayList<PedidoAlmacenItem>();
	
	public Long getPedidoId() {
		return pedidoId;
	}
	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}
	public Date getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public String getSolicitadoPor() {
		return solicitadoPor;
	}
	public void setSolicitadoPor(String solicitadoPor) {
		this.solicitadoPor = solicitadoPor;
	}
	public Date getFechaAutorizacion() {
		return fechaAutorizacion;
	}
	public void setFechaAutorizacion(Date fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
	}
	public String getAutorizadoPor() {
		return autorizadoPor;
	}
	public void setAutorizadoPor(String autorizadoPor) {
		this.autorizadoPor = autorizadoPor;
	}
	public Date getFechaAtencion() {
		return fechaAtencion;
	}
	public void setFechaAtencion(Date fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}
	public String getAtendidoPor() {
		return atendidoPor;
	}
	public void setAtendidoPor(String atendidoPor) {
		this.atendidoPor = atendidoPor;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public List<PedidoAlmacenItem> getPedidoAlmacenItems() {
		return pedidoAlmacenItems;
	}
	public void setPedidoAlmacenItems(List<PedidoAlmacenItem> pedidoAlmacenItems) {
		this.pedidoAlmacenItems = pedidoAlmacenItems;
	}
	public String toString() {
		return getPedidoId().toString();
	}
	public void addPedidoAlmacenItem(PedidoAlmacenItem pedidoAlmacenItem){
		pedidoAlmacenItems.add(pedidoAlmacenItem);
	}
	
	public void addPedidoAlmacenItem(Cart cart){
		Iterator<CartItem> i = cart.getAllCartItems();
		while(i.hasNext()){
			CartItem cartItem = (CartItem) i.next();
			PedidoAlmacenItem pedidoAlmacenItem = new PedidoAlmacenItem(cartItem);
			addPedidoAlmacenItem(pedidoAlmacenItem);
		}
	}

}
