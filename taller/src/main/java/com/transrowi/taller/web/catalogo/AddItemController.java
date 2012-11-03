package com.transrowi.taller.web.catalogo;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.transrowi.taller.domain.Familia;
import com.transrowi.taller.domain.Item;
import com.transrowi.taller.domain.UnidadMedida;

//import com.transrowi.taller.domain.UnidadMedida;

import com.transrowi.taller.service.CatalogoException;
import com.transrowi.taller.service.CatalogoService;
import com.transrowi.taller.web.catalogo.form.FormItem;

@Controller
@RequestMapping("catalogo/addItem")
@SessionAttributes("formItem")
public class AddItemController {
	
	@Autowired
	private CatalogoService catalogoService;
	/*
	@ModelAttribute("formGrupo")
	public FormGrupo createFormGrupo(){
		return new FormGrupo();
	}
	*/
	/*
	@RequestMapping(method=RequestMethod.GET)
	public FormItem formBackingObject(HttpServletRequest request, 
			@RequestParam("familiaId") String familiaId) 
			throws ServerException{
		FormItem formItem= new FormItem();
		String itemCodigo = null;
		try {
			itemCodigo = catalogoService.generarCodigoItem(Integer.valueOf(familiaId));
		} catch (CatalogoException e) {
			// Se llego al maximo permitido
			//redirect maximo permitodo
		}
		formItem.setFamiliaId(Integer.valueOf(familiaId));
		formItem.setItemCodigo(itemCodigo);
		//model.addAttribute("unidadMedidaList", catalogoService.getUnidadMedidaList());
		formItem.setUnidadMedidaList(catalogoService.getUnidadMedidaList());
		return formItem;
	}
	*/
	@RequestMapping(method=RequestMethod.GET)
	public String loadForm(Model model, FormItem formItem, @RequestParam("familiaId")String familiaId){
		System.out.println("load form");
		Familia familia = catalogoService.getFamilia(Integer.valueOf(familiaId));
		String limiteMaximo = null;
		List<UnidadMedida> unidadMedidaList = catalogoService.getUnidadMedidaList();
		String itemCodigo = null;
		
		try {
			itemCodigo = catalogoService.generarCodigoItem(Integer.valueOf(familiaId));
			formItem.setFamiliaId(Integer.valueOf(familiaId));
			formItem.setItemCodigo(itemCodigo);
			model.addAttribute(unidadMedidaList);
			model.addAttribute("familia", familia.getDescripcion());
		} catch (CatalogoException e) {
			limiteMaximo = "Se ha llegado al maximo de items permitidos para la familia "+familia.getDescripcion();
			model.addAttribute("limiteMaximo", limiteMaximo);
			model.addAttribute("familiaId", familiaId);
	
		}

		return "catalogo/addItem";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String processSubmit(@ModelAttribute("formItem") FormItem formItem, SessionStatus status){
		System.out.println("process submit");
		
		//here implementar validaciones
		Item item= new Item();
		
		//tratar parametros ocultos para ver sin se trata de un insert or update
		item.setDescripcion(formItem.getDescripcion().toUpperCase());
		item.setFamiliaId(formItem.getFamiliaId());
		item.setItemCodigo(formItem.getItemCodigo());
		item.setUnidadMedidaId(formItem.getUnidadMedidaId());

		catalogoService.insertItem(item);
		
		status.setComplete();
		return "redirect:/catalogo/verItems?familiaId="+item.getFamiliaId();
	}
	
	

}
