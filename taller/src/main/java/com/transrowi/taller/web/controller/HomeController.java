package com.transrowi.taller.web.controller;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.transrowi.taller.domain.Grupo;
import com.transrowi.taller.service.CatalogoService;

@Controller
public class HomeController {
	
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private CatalogoService catalogoService;
	
	@RequestMapping(value="/")
	public String home(){
		log.info("HomeController: Passing by method home of transrowi");
		return "home";
	}
	
	@RequestMapping(value="/menu")
	public String menu(Model model){
		log.info("Home controler: passing by method menu");
		model.addAttribute("nombre", "daniel");
		List<Grupo> grupoList = catalogoService.getGrupoList();
		model.addAttribute("grupoList", grupoList);
		return "menu";
	}
}
