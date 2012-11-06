package com.transrowi.taller.web.catalogo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.transrowi.taller.domain.Familia;
import com.transrowi.taller.domain.Grupo;
import com.transrowi.taller.service.CatalogoException;
import com.transrowi.taller.service.CatalogoService;
import com.transrowi.taller.web.catalogo.form.FormFamilia;
import com.transrowi.taller.web.catalogo.form.FormFamiliaValidator;

@Controller
@RequestMapping("catalogo/addFamilia")
@SessionAttributes("formFamilia")
public class AddFamiliaController {
	
	@Autowired
	private CatalogoService catalogoService;
	
	@Autowired
	private FormFamiliaValidator familiaValidator;
	
	@RequestMapping(method=RequestMethod.GET)
	public String loadForm(Model model, FormFamilia formFamilia, @RequestParam("grupoId") String grupoId){
		
		Grupo grupo = catalogoService.getGrupo(Integer.valueOf(grupoId));
		String limiteMaximo = null;
		String familiaCodigo = null;
		
		try {
			familiaCodigo = catalogoService.generarCodigoFamilia(Integer.valueOf(grupoId));
			formFamilia.setGrupoId(Integer.valueOf(grupoId));
			formFamilia.setFamiliaCodigo(familiaCodigo);
			model.addAttribute("grupo", grupo.getDescripcion());
		} catch (CatalogoException e) {
			limiteMaximo = "Limite maximo de grupo superado.";
			model.addAttribute("limiteMaximo", limiteMaximo);
		}
		
		return "catalogo/addFamilia";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String processSubmit(
							Model model,
							@ModelAttribute("formFamilia")FormFamilia formFamilia, 
							SessionStatus status,
							BindingResult result){
		
		familiaValidator.validate(formFamilia, result);
		
		if (result.hasErrors()){
			Grupo grupo = catalogoService.getGrupo(formFamilia.getGrupoId());
			model.addAttribute("grupo", grupo.getDescripcion());
			return "catalogo/addFamilia";
		}
		
		//here implementar validaciones
		Familia familia = new Familia();
		
		//tratar parametros ocultos para ver sin se trata de un insert or update
		familia.setDescripcion(formFamilia.getDescripcion().toUpperCase());
		familia.setGrupoId(formFamilia.getGrupoId());
		familia.setFamiliaCodigo(formFamilia.getFamiliaCodigo());
		
		catalogoService.insertFamilia(familia);
		
		status.setComplete();
		
		return "redirect:/catalogo/verFamilias?grupoId="+familia.getGrupoId();
	}
}
