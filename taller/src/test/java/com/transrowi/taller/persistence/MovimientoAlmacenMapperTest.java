package com.transrowi.taller.persistence;

import java.util.Calendar;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.transrowi.taller.domain.MovimientoAlmacen;
import com.transrowi.taller.domain.TipoMovimientoAlmacen;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
@Transactional
public class MovimientoAlmacenMapperTest {
	
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private MovimientoAlmacenMapper movimientoAlmacenMapper;
	
	private MovimientoAlmacen movimientoAlmacen;
	private Calendar fechaMovimiento = Calendar.getInstance();
	
	
	@Test
	public void insertMovimimientoAlmacenTest(){
		fechaMovimiento.add(Calendar.DAY_OF_MONTH, 1);
		movimientoAlmacen = new MovimientoAlmacen();
		movimientoAlmacen.setMovimientoId(2L);
		movimientoAlmacen.setFechaMovimiento(fechaMovimiento.getTime());
		movimientoAlmacen.setAlmacenId(1);
		movimientoAlmacen.setTipoMovimiento(1);//1 = entrada, 2= salida
		movimientoAlmacen.setCorrelativo(1);
		
		log.info("insertMovimientoAlmacenTest");
		
		log.info("assertNotNull before insert");
		Assert.assertNull(movimientoAlmacenMapper.getMovimientoAlmacen(2L));
		
		log.info("invoke insertMovimientoAlmacen");
		movimientoAlmacenMapper.insertMovimientoAlmacen(movimientoAlmacen);
		
		log.info("assertNotNull getMovimientoAlmacen");
		Assert.assertNotNull(movimientoAlmacenMapper.getMovimientoAlmacen(2L));
		log.info("assertNotNull getFechaMovimiento");
		Assert.assertNotNull(movimientoAlmacenMapper.getMovimientoAlmacen(2L).getFechaMovimiento());
		log.info("assertNull getFechaAutorizado");
		log.info(TipoMovimientoAlmacen.ENTRADA);
	}

	
}
