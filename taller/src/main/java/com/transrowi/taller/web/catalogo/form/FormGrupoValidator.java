package com.transrowi.taller.web.catalogo.form;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service
public class FormGrupoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return FormGrupo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcion", "field.required", "Descripcion es requerido");
		
	}

}
