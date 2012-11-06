package com.transrowi.taller.web.catalogo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.transrowi.taller.domain.Grupo;
import com.transrowi.taller.service.CatalogoException;
import com.transrowi.taller.service.CatalogoService;
import com.transrowi.taller.web.catalogo.form.FormGrupo;
import com.transrowi.taller.web.catalogo.form.FormGrupoValidator;

@Controller
@RequestMapping("catalogo/addGrupo")
@SessionAttributes("formGrupo")
public class AddGrupoController {
	
	@Autowired
	private FormGrupoValidator grupoValidator;
	
	@Autowired
	private CatalogoService catalogoService;
	

	@RequestMapping(method = RequestMethod.GET)
	public String loadForm(Model model, FormGrupo formGrupo) {
		formGrupo.setGrupoId(4);
		String limiteMaximo = null;
		String codigoGrupo = null;

		try {
			codigoGrupo = catalogoService.generarCodigoGrupo();
			formGrupo.setGrupoCodigo(codigoGrupo);
		} catch (CatalogoException e) {
			limiteMaximo = "Se llego al limite de grupos permitidos.";
			model.addAttribute("limiteMaximo", limiteMaximo);
		}
		return "catalogo/addGrupo";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(
			@ModelAttribute("formGrupo") FormGrupo formGrupo,
			SessionStatus status,
			BindingResult result) {

		grupoValidator.validate(formGrupo, result);
	
		if (result.hasErrors()){
			return "catalogo/addGrupo";
		}else{
				
			// here implementar validaciones
			Grupo grupo = new Grupo();
			grupo.setGrupoId(formGrupo.getGrupoId());
			grupo.setGrupoCodigo(formGrupo.getGrupoCodigo());
			grupo.setDescripcion(formGrupo.getDescripcion().toUpperCase());
	
			catalogoService.insertGrupo(grupo);
			
			status.setComplete();
	
			return "redirect:/catalogo/grupoList";
		}
	}

}
