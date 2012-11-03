package com.transrowi.taller.persistence;

import java.math.BigDecimal;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.transrowi.taller.domain.MovimientoAlmacenItem;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
@Transactional
public class MovimientoAlmacenItemMapperTest {
	
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private MovimientoAlmacenItemMapper movimientoAlmacenItemMapper;
	@Autowired
	private MovimientoAlmacenMapper movimientoAlmacenMapper;
	
	
	private MovimientoAlmacenItem movimientoAlmacenItem;

	
	@Test
	public void getMovimientoAlmacenItemTest(){
		log.info("getMovimientoAlmacenItemTest");
		
		int sizeMovimientoAlmacenItemList;
		sizeMovimientoAlmacenItemList = movimientoAlmacenItemMapper.getMovimientoAlmacenItemsByMovimientoId(1L).size();
		
		log.info("asserEqual sizeMovimientoAlmacenItemList");
		Assert.assertEquals(3, sizeMovimientoAlmacenItemList);
	}
	
	@Test
	public void insertPedidoAlmacenItemAutorizadoTest(){
		movimientoAlmacenItem = new MovimientoAlmacenItem();
		movimientoAlmacenItem.setMovimientoId(1L);
		movimientoAlmacenItem.setItemId(3);
		movimientoAlmacenItem.setUnidadMedidaId(3);
		movimientoAlmacenItem.setCantidadMovimiento(new BigDecimal("1.5"));
		movimientoAlmacenItem.setCostoUnitario(new BigDecimal("2.75"));
		
		log.info("Init insert movimiento almacen item");

		movimientoAlmacenItemMapper.insertMovimientoAlmacenItem(movimientoAlmacenItem);
	
		Assert.assertNotNull(movimientoAlmacenItemMapper.getMovimientoAlmacenItemsByMovimientoId(1L).get(2));
		 
	}
	
}
