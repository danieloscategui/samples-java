package com.transrowi.taller.web.almacen.form;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service
public class FormPedidoAlmacenValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return FormPedidoAlmacen.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "solicitadoPor", "field.required", "Campo requerido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "autorizadoPor", "field.required", "Campo requerido");		
	}
}
