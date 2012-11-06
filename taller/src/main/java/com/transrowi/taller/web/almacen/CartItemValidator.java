package com.transrowi.taller.web.almacen;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.transrowi.taller.domain.CartItem;

@Service
public class CartItemValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return CartItem.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BigDecimal zero = BigDecimal.ZERO;
		
		CartItem cartItem = (CartItem) target;
		if (cartItem.getCantidad().equals(zero) || cartItem.getCantidad() == null){
			errors.rejectValue("cantidad", "field.required", "Corrija la cantidad");
		}
	}

}
