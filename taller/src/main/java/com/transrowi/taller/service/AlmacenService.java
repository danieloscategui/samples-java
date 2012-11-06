package com.transrowi.taller.service;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transrowi.taller.domain.Item;
import com.transrowi.taller.domain.MovimientoAlmacen;
import com.transrowi.taller.domain.MovimientoAlmacenItem;
import com.transrowi.taller.domain.PedidoAlmacen;
import com.transrowi.taller.domain.PedidoAlmacenEstado;
import com.transrowi.taller.domain.PedidoAlmacenItem;
import com.transrowi.taller.domain.Sequence;
import com.transrowi.taller.domain.TipoMovimientoAlmacen;
import com.transrowi.taller.domain.UnidadMedida;
import com.transrowi.taller.persistence.AlmacenMapper;
import com.transrowi.taller.persistence.MovimientoAlmacenItemMapper;
import com.transrowi.taller.persistence.MovimientoAlmacenMapper;
import com.transrowi.taller.persistence.PedidoAlmacenItemMapper;
import com.transrowi.taller.persistence.PedidoAlmacenMapper;
import com.transrowi.taller.persistence.SequenceMapper;
import com.transrowi.taller.persistence.UnidadMedidaMapper;

@Service
public class AlmacenService {
	
	@Autowired
	private SequenceMapper sequenceMapper;
	@Autowired
	private UnidadMedidaMapper unidadMedidaMapper;
	@Autowired
	private AlmacenMapper almacenMapper; 
	@Autowired
	private PedidoAlmacenMapper pedidoAlmacenMapper;
	@Autowired
	private PedidoAlmacenItemMapper pedidoAlmacenItemMapper;
	@Autowired
	private MovimientoAlmacenMapper movimientoAlmacenMapper;
	@Autowired
	private MovimientoAlmacenItemMapper movimientoAlmacenItemMapper;

	
	
	public List<Item> getItemList(){
		return almacenMapper.getItemList();
	}
	
	public List<Item> searchItemList(String keyword){
		return almacenMapper.searchItemList("%"+keyword.toLowerCase()+"%");
	}
	
	public List<UnidadMedida> getUnidadMedidaList(){
		return unidadMedidaMapper.getUnidadMedidaList();
	}
	
	public boolean isItemInStock(Integer itemId) {
		return almacenMapper.getInventoryQuantity(itemId).compareTo(new BigDecimal("0.00")) == 1;
	}
	
	public Item getItem(Integer itemId) {
		return almacenMapper.getItem(itemId);
	}
	
	//desde aqui toda la logica de guardar un pedido en la base de datos
	//public void
	@Transactional
	public Long insertPedidoAlmacen(PedidoAlmacen pedidoAlmacen) {
		pedidoAlmacen.setPedidoId(Long.valueOf(getNextId("pedidonum")));
		pedidoAlmacenMapper.insertPedidoAlmacen(pedidoAlmacen);
		for (int i = 0; i < pedidoAlmacen.getPedidoAlmacenItems().size()  ; i++) {
			PedidoAlmacenItem pedidoAlmacenItem = (PedidoAlmacenItem) pedidoAlmacen.getPedidoAlmacenItems().get(i);
			pedidoAlmacenItem.setPedidoId(pedidoAlmacen.getPedidoId());
			pedidoAlmacenItemMapper.insertPedidoAlmacenItem(pedidoAlmacenItem);
		}
		return pedidoAlmacen.getPedidoId();
	}

	@Transactional
	public void autorizarPedidoAlmacen(PedidoAlmacen pedidoAlmacen){
		pedidoAlmacenMapper.updatePedidoAlmacenAutorizado(pedidoAlmacen);
		for (int i = 0; i < pedidoAlmacen.getPedidoAlmacenItems().size(); i++) {
			PedidoAlmacenItem pedidoAlmacenItem = pedidoAlmacen.getPedidoAlmacenItems().get(i);
			pedidoAlmacenItemMapper.updatePedidoAlmacenItemAutorizado(pedidoAlmacenItem);
		}
	}
	
	@Transactional
	public void atenderPedidoAlmacen(PedidoAlmacen pedidoAlmacen){
		//actualizar pedido almacen
		pedidoAlmacenMapper.updatePedidoAlmacenAtendido(pedidoAlmacen);
		for (PedidoAlmacenItem pedidoAlmacenItem : pedidoAlmacen.getPedidoAlmacenItems()) {
			pedidoAlmacenItemMapper.updatePedidoAlmacenItemAtendido(pedidoAlmacenItem);
		}
		
		//insert nuevo movimiento
		
		MovimientoAlmacen movimientoAlmacen = new MovimientoAlmacen();
		movimientoAlmacen.setMovimientoId(Long.valueOf(getNextId("movimientonum")));
		movimientoAlmacen.setAlmacenId(1);
		movimientoAlmacen.setFechaMovimiento(pedidoAlmacen.getFechaAtencion());
		movimientoAlmacen.setTipoMovimiento(TipoMovimientoAlmacen.SALIDA.getValue());
		movimientoAlmacen.setCorrelativo(getCorrelativoMovimientoAmacen(TipoMovimientoAlmacen.ENTRADA));
		
		movimientoAlmacenMapper.insertMovimientoAlmacen(movimientoAlmacen);
		for (PedidoAlmacenItem pedidoAlmacenItem : pedidoAlmacen.getPedidoAlmacenItems()) {
				MovimientoAlmacenItem movimientoAlmacenItem = new MovimientoAlmacenItem();
				
				movimientoAlmacenItem.setMovimientoId(movimientoAlmacen.getMovimientoId());
				movimientoAlmacenItem.setItemId(pedidoAlmacenItem.getItem().getItemId());
				movimientoAlmacenItem.setUnidadMedidaId(pedidoAlmacenItem.getUnidadMedidaId());
		}
		
		//update stock
		
	}
	
	public Long getCorrelativoMovimientoAmacen(TipoMovimientoAlmacen tipoMovimiento) {
		Long correlativo ;
		correlativo = movimientoAlmacenMapper.getCorrelativo(tipoMovimiento.getValue());
		
		if (correlativo == null || correlativo == 0 ){
			return 1L;
		}
		
		return correlativo + 1L;
	}

	//metodo para la sequencia de id's
	private String getNextId(String name){
		Sequence sequence = new Sequence(name, -1L);
		sequence = sequenceMapper.getSequence(sequence);
		if (sequence == null){
			throw new RuntimeException("Error: La sequencia,"+name+" retornado null desde la base de datos.");
		}
		Sequence parameterObject = new Sequence(name, sequence.getNextId()+ 1L);
		sequenceMapper.updateSequence(parameterObject);
		return sequence.getNextId().toString();
	}

	public PedidoAlmacen getPedidoAlmacenById(Long pedidoAlmacenId) {
		// TODO Auto-generated method stub
		PedidoAlmacen pedidoAlmacen = pedidoAlmacenMapper.getPedidoAlmacen(pedidoAlmacenId);
		List<PedidoAlmacenItem> itemList = pedidoAlmacenItemMapper.getPedidoAlmacenItemsByPedidoId(pedidoAlmacenId);
		pedidoAlmacen.setPedidoAlmacenItems(itemList);
		
		return pedidoAlmacen;
		
	}
	
	public List<PedidoAlmacen> getPedidoAlmacenByEstado(PedidoAlmacenEstado estado){
		
		return pedidoAlmacenMapper.getPedidoAlmacenByEstado(estado.toString());
	    
	}
	
}