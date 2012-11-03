package com.transrowi.taller.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem implements Serializable{

	private static final long serialVersionUID = -5728841265487087359L;
	
	private Item item;
	private BigDecimal cantidad;
	private boolean inStock;
	private BigDecimal total;
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
		calculateTotal();
	}
	public BigDecimal getCantidad() {
		return cantidad;
	}
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
		calculateTotal();
	}
	public boolean getInStock() {
		return inStock;
	}
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void calculateTotal() {
		if (item != null && item.getPrecioLista()!= null && cantidad != null){
			total = item.getPrecioLista().multiply(cantidad);
		}else{
			total = null;
		}
	}
	public void incrementCantidad(){
		cantidad = cantidad.add(new BigDecimal("1.00"));
		calculateTotal();
	}
}
