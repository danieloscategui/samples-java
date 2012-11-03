package com.transrowi.taller.persistence;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.transrowi.taller.domain.PedidoAlmacen;
import com.transrowi.taller.domain.PedidoAlmacenItem;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
@Transactional
public class PedidoAlmacenItemMapperTest {
	
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private PedidoAlmacenItemMapper pedidoAlmacenItemMapper;
	@Autowired
	private PedidoAlmacenMapper pedidoAlmacenMapper;
	
	
	private PedidoAlmacenItem pedidoAlmacenItem;
	private PedidoAlmacen pedidoAlmacen;
	
	@Before
	public void insertPedidoAlmacen(){
		pedidoAlmacen = new PedidoAlmacen();
		pedidoAlmacen.setPedidoId(2L);
		pedidoAlmacen.setFechaPedido(new Date());
		pedidoAlmacen.setSolicitadoPor("daniel");
		pedidoAlmacen.setEstado("pendiente");
		pedidoAlmacenMapper.insertPedidoAlmacen(pedidoAlmacen);
	}
	@Test
	public void getPedidoAlmacenItemTest(){
		pedidoAlmacenItem = new PedidoAlmacenItem();
		pedidoAlmacenItem.setPedidoId(2L);
		pedidoAlmacenItem.setItemId(3);
		pedidoAlmacenItem.setUnidadMedidaId(3);
		pedidoAlmacenItem.setCantidadSolicitada(new BigDecimal("5.0"));
				
		log.info("getPedidoAlmacenItemTest");
		log.info("asserEqual getPedidoAlmacenItemBbyPedidoId");
		Assert.assertEquals(0, pedidoAlmacenItemMapper.getPedidoAlmacenItemsByPedidoId(2L).size());
		log.info("invoke insertPedidoAlmacenItem");
		pedidoAlmacenItemMapper.insertPedidoAlmacenItem(pedidoAlmacenItem);
		log.info("assertEqual getPedidoAlmacenItemByPedidoId");
		Assert.assertEquals(1, pedidoAlmacenItemMapper.getPedidoAlmacenItemsByPedidoId(2L).size());

	}
	@Test
	public void updatePedidoAlmacenItemAutorizadoTest(){
		pedidoAlmacenItem = new PedidoAlmacenItem();
		pedidoAlmacenItem.setPedidoId(1L);
		pedidoAlmacenItem.setItemId(3);
		pedidoAlmacenItem.setUnidadMedidaId(3);
		pedidoAlmacenItem.setCantidadSolicitada(new BigDecimal("5.0"));
		
		log.info("Init insert pedido almacen item");
		log.info(pedidoAlmacenItem.getCantidadSolicitada());
		pedidoAlmacenItemMapper.insertPedidoAlmacenItem(pedidoAlmacenItem);
		
		pedidoAlmacenItem = pedidoAlmacenItemMapper.getPedidoAlmacenItemsByPedidoId(1L).get(0);
		Assert.assertNull(pedidoAlmacenItem.getCantidadAtendida());
		
		log.info("update cantidad autorizada");
		pedidoAlmacenItem.setCantidadAutorizada(new BigDecimal("4.5"));
		pedidoAlmacenItemMapper.updatePedidoAlmacenItemAutorizado(pedidoAlmacenItem);
		pedidoAlmacenItem = pedidoAlmacenItemMapper.getPedidoAlmacenItemsByPedidoId(1L).get(0);
		//Assert.assertEquals(new BigDecimal("4.5"), pedidoAlmacenItem.getCantidadAutorizada());
	}
	
	@Test
	public void updatePedidoAlmacenItemAtendidoTest(){
		pedidoAlmacenItem = new PedidoAlmacenItem();
		pedidoAlmacenItem.setPedidoId(1L);
		pedidoAlmacenItem.setItemId(3);
		pedidoAlmacenItem.setUnidadMedidaId(3);
		pedidoAlmacenItem.setCantidadSolicitada(new BigDecimal("5.0"));
		
		log.info("Init insert pedido almacen item");
		log.info(pedidoAlmacenItem.getCantidadSolicitada());
		pedidoAlmacenItemMapper.insertPedidoAlmacenItem(pedidoAlmacenItem);
		
		pedidoAlmacenItem = pedidoAlmacenItemMapper.getPedidoAlmacenItemsByPedidoId(1L).get(0);
		Assert.assertNull(pedidoAlmacenItem.getCantidadAtendida());
		
		log.info("update cantidad atendida");
		pedidoAlmacenItem.setCantidadAtendida(new BigDecimal("4.5"));
		pedidoAlmacenItemMapper.updatePedidoAlmacenItemAutorizado(pedidoAlmacenItem);
		pedidoAlmacenItem = pedidoAlmacenItemMapper.getPedidoAlmacenItemsByPedidoId(1L).get(0);
		//Assert.assertEquals(new BigDecimal("4.5"), pedidoAlmacenItem.getCantidadAtendida());
	}
	
	@Test
	public void getPedidoAlmacenItemDetailTest(){
		log.info("testing getPedidoAlmacenItemDetailTest");
		List<PedidoAlmacenItem> pedidoAlmacenItemList = pedidoAlmacenItemMapper.getPedidoAlmacenItemsByPedidoId(1L);
		Assert.assertNotNull(pedidoAlmacenItemList);
		for (PedidoAlmacenItem items : pedidoAlmacenItemList) {
			log.info(items.getItem().getDescripcion());
			log.info(items.getUnidadMedida().getAcronimo());
		}
		
	}
}
