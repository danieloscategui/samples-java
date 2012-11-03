package com.transrowi.taller.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class PedidoAlmacenItem  implements Serializable{

	private static final long serialVersionUID = -6723170404351705106L;
	
	private Long pedidoId;
	private Item item;
	private Integer itemId;
	private Integer unidadMedidaId;
	private UnidadMedida unidadMedida;
	private BigDecimal cantidadSolicitada;
	private BigDecimal cantidadAutorizada;
	private BigDecimal cantidadAtendida;
	private BigDecimal totalSolicitado;
	private BigDecimal totalAutorizado;
	private BigDecimal totalAtendido;
	
	public PedidoAlmacenItem() {
		// TODO Auto-generated constructor stub
	}
	
	public PedidoAlmacenItem(CartItem cartItem){
		this.item = cartItem.getItem();
		this.itemId = item.getItemId();
		this.unidadMedida = item.getUnidadMedida();
		this.unidadMedidaId = unidadMedida.getUnidadMedidaId();
		this.cantidadSolicitada = cartItem.getCantidad();
	}
	
	
	public Long getPedidoId() {
		return pedidoId;
	}
	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public UnidadMedida getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public BigDecimal getCantidadSolicitada() {
		return cantidadSolicitada;
	}
	public void setCantidadSolicitada(BigDecimal cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
		calcularTotalSolicitado();
	}
	public BigDecimal getCantidadAutorizada() {
		return cantidadAutorizada;
	}
	public void setCantidadAutorizada(BigDecimal cantidadAutorizada) {
		this.cantidadAutorizada = cantidadAutorizada;
		calcularTotalAutorizado();
	}
	public BigDecimal getCantidadAtendida() {
		return cantidadAtendida;
	}
	public void setCantidadAtendida(BigDecimal cantidadAtendida) {
		this.cantidadAtendida = cantidadAtendida;
		calcularTotalAtendido();
	}
	public BigDecimal getTotalSolicitado(){
		return totalSolicitado;
	}
	public BigDecimal getTotalAutorizado(){
		return totalAutorizado;
	}
	public BigDecimal getTotalAtendido(){
		return totalAtendido;
	}
	public Integer getUnidadMedidaId() {
		return unidadMedidaId;
	}
	public void setUnidadMedidaId(Integer unidadMedidaId) {
		this.unidadMedidaId = unidadMedidaId;
	}
	public void calcularTotalSolicitado(){
		if (item != null && item.getPrecioLista() != null ){
			totalSolicitado = item.getPrecioLista().multiply(cantidadSolicitada);
		} else {
			totalSolicitado = null;
		}
	}
	public void calcularTotalAutorizado(){
		if (item != null && item.getPrecioLista() != null){
			totalAutorizado = item.getPrecioLista().multiply(cantidadAutorizada);
		} else {
			totalAutorizado = null;
		}
	}
	public void calcularTotalAtendido(){
		if (item != null && item.getPrecioLista() != null){
			totalAtendido = item.getPrecioLista().multiply(cantidadAtendida);
		} else {
			totalAtendido = null;
		}
	}
	
	
}
