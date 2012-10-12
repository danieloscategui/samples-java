package org.mybatis.jpetstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class LineItem implements Serializable {
	
	private static final long serialVersionUID = -4642840108423257026L;
	
	private int orderId;
	private int lineNumber;
	private int quantity;
	private String itemId;
	private BigDecimal unitPrice;
	private Item item;
	private BigDecimal total;
	
	public LineItem() {
	}
	
	public LineItem(int lineNumber, CartItem cartItem){
		this.lineNumber = lineNumber;
		this.quantity = cartItem.getQuantity();
		this.itemId = cartItem.getItem().getItemId();
		this.unitPrice = cartItem.getItem().getListPrice();
		this.item = cartItem.getItem();
	}
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		CalculateTotal();
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
		CalculateTotal();
	}
	public BigDecimal getTotalPrice() {
		return total;
	}
	public void setTotalPrice(BigDecimal total) {
		this.total = total;
	}
	
	private void CalculateTotal(){
		if ( item != null && item.getListPrice() != null){
			total = item.getListPrice().multiply(new BigDecimal(quantity));
		} else {
			total = null;
		}
	}
}
