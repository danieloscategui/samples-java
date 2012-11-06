package com.transrowi.taller.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class Cart implements Serializable{
	
	private Log log = LogFactory.getLog(getClass());
	

	private static final long serialVersionUID = -8130250415613269472L;
	
	private final Map<Integer, CartItem> itemMap = Collections.synchronizedMap(new HashMap<Integer, CartItem>());
	private final List<CartItem> itemList = new ArrayList<CartItem>();
	
	
	public Iterator<CartItem> getCartItems(){
		return itemList.iterator();
	}
	
	public List<CartItem> getCartItemList(){
		return itemList;
	}
	/*
	public void setCartItemList(List<CartItem> itemlList){
		this.itemList = itemlList;
	}
	*/
	public List<Item> getItemListWithCantidadZero(){
		List<Item> itemList = new ArrayList<Item>();
		for (CartItem cartItem : getCartItemList()) {;
			if (cartItem.getCantidad().equals(BigDecimal.ZERO)){
				itemList.add(cartItem.getItem());
			}
		}
		return itemList;
	}
	
	public int getNumberOfItems(){
		return itemList.size();
	}
	
	public Iterator<CartItem> getAllCartItems(){
		return itemList.iterator();
	}
	
	public boolean containsItemId(Integer itemId){
		return itemMap.containsKey(itemId);
	}
	
	public void cleanCart(){
		if (!itemMap.isEmpty() && !itemList.isEmpty()){
			itemMap.clear();
			itemList.clear();
		}
	}
	
	public void addItem(Item item, boolean isInStock){
		//Search into cartItems
		CartItem cartItem = (CartItem)itemMap.get(item.getItemId());
		if (cartItem == null){
			//create new cartItem
			log.info("Cart.cartItem was null, proceded create and add cartItem");
			cartItem = new CartItem();
			cartItem.setItem(item);
			cartItem.setCantidad(new BigDecimal(0));
			cartItem.setInStock(isInStock);
			itemMap.put(item.getItemId(), cartItem);
			itemList.add(cartItem);
		}
		//if exists increment at 1
		log.info("Cart.cartItem.incrementCantidad at 1.0");
		cartItem.incrementCantidad();
		log.info("Cart.cartItem.cantidad: "+cartItem.getCantidad());
	}
	
	public Item removeItemById(Integer itemId){
		CartItem cartItem = (CartItem)itemMap.remove(itemId);
		if (cartItem == null){
			return null;
		}else{
			itemList.remove(cartItem);
			return cartItem.getItem();
		}
	}
	public void incrementCantidaByItemId(Integer itemId){
		CartItem cartItem = (CartItem)itemMap.get(itemId);
		cartItem.incrementCantidad();
	}
	public void setCantidadByItemId(Integer itemId, BigDecimal cantidad){
		CartItem cartItem = (CartItem)itemMap.get(itemId);
		cartItem.setCantidad(cantidad);
	}
	
	public BigDecimal getSubTotal(){
		BigDecimal subTotal = new BigDecimal("0");
		Iterator<CartItem> items = getAllCartItems();
		while (items.hasNext()) {
			CartItem cartItem = (CartItem) items.next();
			Item item = cartItem.getItem();
			BigDecimal precioLista = item.getPrecioLista();
			BigDecimal cantidad = cartItem.getCantidad();
			subTotal = subTotal.add(precioLista.multiply(cantidad));
		}
		return subTotal;
	}
}
