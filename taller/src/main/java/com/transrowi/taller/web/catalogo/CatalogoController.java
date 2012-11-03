package com.transrowi.taller.web.catalogo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.transrowi.taller.domain.Familia;
import com.transrowi.taller.domain.Grupo;
import com.transrowi.taller.domain.Item;
import com.transrowi.taller.service.CatalogoService;

@Controller
public class CatalogoController {
	
	/**
	 * Clase dedicada a listar grupo, familia, item
	 */
	
	@Autowired
	private CatalogoService catalogoService;
	
	@RequestMapping(value="/verGrupo", method=RequestMethod.GET )
	public String verGrupo(@RequestParam("grupoId")  String grupoId, Model model){
		Grupo grupo = catalogoService.getGrupo(Integer.valueOf(grupoId));
		model.addAttribute("grupo", grupo);
		return "catalogo/grupo";
	}
	
	@RequestMapping(value="/catalogo/grupoList")
	public String grupoList(Model model){
		Map<String, Object> datos = new HashMap<String, Object>();
		List<Grupo> grupoList = catalogoService.getGrupoList();
		
		datos.put("grupoList", grupoList);
		model.addAttribute("model", datos);
		
		return "catalogo/grupoList";
	}
	
	@RequestMapping(value="/catalogo/verFamilias", method=RequestMethod.GET)
	public String verFamilias(Model model, @RequestParam("grupoId")String grupoId){
		Map<String, Object> datos = new HashMap<String, Object>();
		
		List<Familia> familiaList = catalogoService.getFamiliaListByGrupo(Integer.valueOf(grupoId));
		Grupo grupo = catalogoService.getGrupo(Integer.valueOf(grupoId));
		
		datos.put("grupo", grupo);
		datos.put("familiaList", familiaList);
		model.addAttribute("model", datos);
		
		return "catalogo/familiaListByGrupo";
	}
	
	@RequestMapping(value="/catalogo/verItems", method=RequestMethod.GET)
	public String verItems(Model model, @RequestParam("familiaId") String familiaId){
		Map<String, Object> datos = new HashMap<String, Object>();
		List<Item> itemList = catalogoService.getItemListByFamilia(Integer.valueOf(familiaId));
		Familia familia = catalogoService.getFamilia(Integer.valueOf(familiaId));
		
		//String familiaName = catalogoService.getFamilia(Integer.valueOf(familiaId)).getDescripcion();
		
		datos.put("familia", familia);
		datos.put("itemList", itemList);
		
		model.addAttribute("model", datos);
		
		return "catalogo/itemListByFamilia";
	}
	
}
