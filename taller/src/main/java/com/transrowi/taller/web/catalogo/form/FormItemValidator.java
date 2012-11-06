package com.transrowi.taller.web.catalogo.form;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service
public class FormItemValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return FormItem.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcion", "field.required", "Descripcion es requerido");
		
		FormItem formItem = (FormItem) target;
		if ("0".equals(formItem.getUnidadMedidaId())){
			errors.rejectValue("unidadMedidaId", "field.select","Seleccione Unidad Medida");
		}
	}

}
