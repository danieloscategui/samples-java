package com.transrowi.taller.service;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transrowi.taller.domain.Item;
import com.transrowi.taller.domain.PedidoAlmacen;
import com.transrowi.taller.domain.PedidoAlmacenItem;
import com.transrowi.taller.domain.Sequence;
import com.transrowi.taller.domain.UnidadMedida;
import com.transrowi.taller.persistence.AlmacenMapper;
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

	
	
	//Metodos utiles
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
	
}