package com.transrowi.taller.web.almacen;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.transrowi.taller.domain.Cart;
import com.transrowi.taller.domain.CartItem;
import com.transrowi.taller.domain.Item;
import com.transrowi.taller.service.AlmacenService;

@Controller
@SessionAttributes("cart")
public class CartController {
	private Log log = LogFactory.getLog(getClass());
	
	private static final String VIEW_CART = "almacen/cart"; 
	
	@Autowired
	private transient AlmacenService almacenService;
	
	private Cart cart = new Cart();

	@ModelAttribute("cart")
	public Cart getCart() {
		return this.cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="cart/cleanCart")
	public String cleanCart(SessionStatus status){
		status.setComplete();
		//this.cart.cleanCart();
		this.cart = new Cart();
		return "redirect:/almacen/almacenItemList";
	}
	
	@RequestMapping (method=RequestMethod.GET, value="/cart/addItemToCart")
	public String addItemToCart(@RequestParam("itemId")String itemId, HttpServletRequest request){
		log.info("passing by CartController - addItemToCart");
		if (cart.containsItemId(Integer.valueOf(itemId))){
			//verificar si existe stock para incrementar
			cart.incrementCantidaByItemId(Integer.valueOf(itemId));
			log.info("passing by CartController - addItemToCart");
		} else {
			boolean isInStock = almacenService.isItemInStock(Integer.valueOf(itemId));
			Item item = almacenService.getItem(Integer.valueOf(itemId));
			cart.addItem(item, isInStock);
		}
		return VIEW_CART;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/cart/removeItemFromCart")
	public String removeItemFromCart(@RequestParam("itemId") String itemId){
		Item item = cart.removeItemById(Integer.valueOf(itemId));
		if (item == null){
			//String mensaje = "Error item null en removeItemFromCart";
			//here return to show mensajes
			return VIEW_CART;
		} else {
			return VIEW_CART;
		}
	}
	
	@RequestMapping (method=RequestMethod.POST, value="/cart/updateCantidadCart")
	public String updateCantidadCart(@ModelAttribute("cart") Cart cart){
		List<CartItem> itemList = cart.getCartItemList();
		if(itemList != null && itemList.size() > 0){
			for (CartItem cartItem : itemList) {
				log.info("Item: "+cartItem.getItem().getDescripcion()+" - Cantidad: "+cartItem.getCantidad());
			}
		}
		return VIEW_CART;
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/cart/checkout")
	public String updateCartCantidad(HttpServletRequest request,
									Model model){
		log.info("passing by cart/checkout");
		log.info(cart.getNumberOfItems());
		if (cart.getNumberOfItems() == 0){
			return VIEW_CART;
		} else {
			return "redirect:/almacen/newPedidoAlmacen";
		}
	}	
	
	public void clear(){
		this.cart = new Cart();
	}
}
