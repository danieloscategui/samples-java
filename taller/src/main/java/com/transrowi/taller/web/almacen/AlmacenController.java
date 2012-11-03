package com.transrowi.taller.web.almacen;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import sun.misc.Cleaner;

import com.transrowi.taller.domain.Cart;
import com.transrowi.taller.domain.Item;
import com.transrowi.taller.domain.PedidoAlmacen;
import com.transrowi.taller.domain.PedidoAlmacenEstado;
import com.transrowi.taller.service.AlmacenService;
import com.transrowi.taller.web.almacen.form.FormPedidoAlmacen;
import com.transrowi.taller.web.almacen.form.FormSearchItem;

@Controller
@SessionAttributes("cart")
public class AlmacenController {
	private Log log = LogFactory.getLog(getClass());
	
	private final String VIEW_ALMACEN_ITEM_LIST = "almacen/almacenItemList";
	private final String NEW_PEDIDO_ALMACEN = "almacen/newPedidoAlmacen";
	
	@Autowired
	private AlmacenService almacenService;
	
	@ModelAttribute
	public FormSearchItem getFormSearchItem(){
		return new FormSearchItem();
	}
	
	@ModelAttribute
	public FormPedidoAlmacen getFormPedidoAlmacen(){
		return new FormPedidoAlmacen();
	}
	
	@RequestMapping(value="/almacen/createNuevoPedido", method=RequestMethod.GET)
	public String createNuevoPedido(){
		return "redirect:/cart/cleanCart";
	}
	
	@RequestMapping(value="/almacen/almacenItemList", method=RequestMethod.GET)
	public String itemLIst(Model model){
		List<Item> itemList = almacenService.getItemList();
		log.info("itemListSize: "+itemList.size());
		
		model.addAttribute("itemList", itemList);
		
		return VIEW_ALMACEN_ITEM_LIST;
	}
	
	
	@RequestMapping(value="/almacen/searchAlmacenItem", method=RequestMethod.POST)
	public String searchAlmacenItem(Model model, @ModelAttribute("fromSearchItem") FormSearchItem formSearchItem){
		
		List<Item> itemList = almacenService.searchItemList(formSearchItem.getKeyword());
		model.addAttribute("itemList", itemList);
		return VIEW_ALMACEN_ITEM_LIST;
	}
	
	@RequestMapping(value="/almacen/newPedidoAlmacen", method=RequestMethod.GET)
	public String newPedidoAlmacen(Model model, 
								@ModelAttribute("formPedidoAlmacen")FormPedidoAlmacen formPedidoAlmacen,
								HttpServletRequest request){
		log.info("passing at newPedidoAlmacen");
		return NEW_PEDIDO_ALMACEN;
	}
	
	@RequestMapping(value="/almacen/confirmarPedido", method=RequestMethod.POST)
	public String confirmarPedido(Model model,
								@ModelAttribute("formPedidoAlmacen")FormPedidoAlmacen formPedidoAlmacen,
								HttpServletRequest request,
								SessionStatus status){
		log.info("passing by confirmarPedido");
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		log.info(cart);
		
		Calendar calendar = Calendar.getInstance();
		Long pedidoAlmacenId;
		
		PedidoAlmacen pedidoAlmacen = new PedidoAlmacen();
		pedidoAlmacen.setFechaPedido(calendar.getTime());
		pedidoAlmacen.setEstado(PedidoAlmacenEstado.PENDIENTE.toString());
		pedidoAlmacen.setSolicitadoPor(formPedidoAlmacen.getSolicitadoPor().toUpperCase());
		
		pedidoAlmacen.addPedidoAlmacenItem(cart);
		
		pedidoAlmacenId =  almacenService.insertPedidoAlmacen(pedidoAlmacen);
		

		status.setComplete();
		
		pedidoAlmacen = null;
		pedidoAlmacen = almacenService.getPedidoAlmacenById(pedidoAlmacenId);
		
		model.addAttribute("pedidoAlmacen", pedidoAlmacen);
		
		return "almacen/mostrarPedidoAlmacen";
	}
}
