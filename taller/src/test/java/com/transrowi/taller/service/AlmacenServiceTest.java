package com.transrowi.taller.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.transrowi.taller.domain.Item;
import com.transrowi.taller.domain.TipoMovimientoAlmacen;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
@Transactional
public class AlmacenServiceTest {
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private AlmacenService almacenService;
	
	@Test
	public void testGetItemListNotNull(){
		log.info("testing testGetItemListNotNull");
		List<Item> itemList = almacenService.getItemList();
		assertNotNull(itemList);
	}
	
	@Test
	public void testSizeGetItemList(){
		log.info("testing testSizeGetItemList");
		Integer sizeItemListExpected = 3;
		Integer sizeItemListActual = almacenService.getItemList().size();
		
		assertEquals(sizeItemListExpected, sizeItemListActual);
	}
	
	@Test
	public void testGetCorrelativoEntrada(){
		log.info("testing getcorrelativo entrada");
		Long expected = 2L;
		Long actual = almacenService.getCorrelativoMovimientoAmacen(TipoMovimientoAlmacen.ENTRADA);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetCorrelativoSalida(){
		log.info("testing getcorrelativo salida");
		Long expected = 1L;
		Long actual = almacenService.getCorrelativoMovimientoAmacen(TipoMovimientoAlmacen.SALIDA);
		assertEquals(expected, actual);
		
	}
}
