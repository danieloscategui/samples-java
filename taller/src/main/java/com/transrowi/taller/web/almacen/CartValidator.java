package com.transrowi.taller.web.almacen;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.transrowi.taller.domain.Cart;
import com.transrowi.taller.domain.CartItem;

@Service
public class CartValidator implements Validator{

	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Cart.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Cart cart = (Cart) target;
		
		boolean isEqualNullOrZero = false;
		if (cart.getNumberOfItems()> 0){
			for (CartItem cartItem : cart.getCartItemList()) {
				System.out.println("CartItem.cantidad: "+cartItem.getCantidad());
				
				if (cartItem.getCantidad() == null || (cartItem.getCantidad().equals(BigDecimal.ZERO))){
					System.out.println("Validator not passing");
					isEqualNullOrZero = true;
					break;
				}
			}
		}
		
		if (isEqualNullOrZero){
			errors.reject("field.required", "Cantidad no debe ser 0");
		}
	}

}
