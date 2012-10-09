package org.mybatis.jpetstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem implements Serializable {

	private static final long serialVersionUID = 141008901336749015L;

	private Item item;
	private int quantity;
	private boolean inStock;
	private BigDecimal total;
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
		calculateTotal();
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		calculateTotal();
	}
	public boolean isInStock() {
		return inStock;
	}
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public void incrementeQuantity(){
		quantity++;
		calculateTotal();
	}
	private void calculateTotal(){
		if(item != null && item.getListPrice() != null){
			total = item.getListPrice().multiply(new BigDecimal(quantity));
		}else{
			total = null;
		}
	}
	
	
}
