package com.transrowi.taller.persistence;

import java.util.Calendar;


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


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
@Transactional
public class PedidoAlmacenMapperTest {
	
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private PedidoAlmacenMapper pedidoAlmacenMapper;
	
	private PedidoAlmacen pedidoAlmacen;
	private Calendar fechaPedido = Calendar.getInstance();
	private Calendar fechaAutorizacion = Calendar.getInstance();
	private Calendar fechaAtencion = Calendar.getInstance();
	
	@Before
	public void insertPedidoAlmacen(){
		pedidoAlmacen = new PedidoAlmacen();
		pedidoAlmacen.setPedidoId(1L);
		pedidoAlmacen.setFechaPedido(fechaPedido.getTime());
		pedidoAlmacen.setSolicitadoPor("Daniel");
		pedidoAlmacen.setEstado("pendiente");
		pedidoAlmacenMapper.insertPedidoAlmacen(pedidoAlmacen);
	}
	
	@Test
	public void insertAndGetPedidoAlmacenTest(){
		fechaPedido.add(Calendar.DAY_OF_MONTH, -2);
		pedidoAlmacen = new PedidoAlmacen();
		pedidoAlmacen.setPedidoId(2L);
		pedidoAlmacen.setFechaPedido(fechaPedido.getTime());
		pedidoAlmacen.setSolicitadoPor("Danie12");
		pedidoAlmacen.setEstado("pendiente");
		
		log.info("insertAndGetPedidoAlmacenTest");
		log.info("assertNotNull getPedidoAlmacen");
		Assert.assertNotNull(pedidoAlmacenMapper.getPedidoAlmacen(1L));
		log.info("invoke insertPedidoAlmacen");
		pedidoAlmacenMapper.insertPedidoAlmacen(pedidoAlmacen);
		log.info("assertNotNull getPedidoAlmacen");
		Assert.assertNotNull(pedidoAlmacenMapper.getPedidoAlmacen(2L));
		log.info("assertNull getObservacion");
		Assert.assertNull(pedidoAlmacenMapper.getPedidoAlmacen(1L).getObservacion());
		log.info("assertNull getFechaAutorizado");
		Assert.assertNull(pedidoAlmacenMapper.getPedidoAlmacen(1L).getFechaAutorizacion());
		log.info(pedidoAlmacen.getFechaPedido());
	}

	@Test
	public void updatePedidoAlmacenAutorizadoTest(){
		fechaPedido.add(Calendar.DAY_OF_MONTH, -5);
		pedidoAlmacen = new PedidoAlmacen();
		pedidoAlmacen.setPedidoId(3L);
		pedidoAlmacen.setFechaPedido(fechaPedido.getTime());
		pedidoAlmacen.setSolicitadoPor("Carlos");
		pedidoAlmacen.setEstado("pendiente");
		
		pedidoAlmacenMapper.insertPedidoAlmacen(pedidoAlmacen);
		pedidoAlmacen = null;
		pedidoAlmacen = pedidoAlmacenMapper.getPedidoAlmacen(3L);
		log.info(pedidoAlmacenMapper.getPedidoAlmacen(3L).getFechaPedido());
		
		fechaAutorizacion.add(Calendar.DAY_OF_MONTH, 10);
		pedidoAlmacen.setFechaAutorizacion(fechaAutorizacion.getTime());
		pedidoAlmacen.setAutorizadoPor("Jhon");
		pedidoAlmacen.setEstado("AUTRIZADO");
		//log.info(pedidoAlmacen.getFechaPedido());
		log.info("updatePedidoAlmacenAutorizadoTest");
		pedidoAlmacenMapper.updatePedidoAlmacenAutorizado(pedidoAlmacen);
		log.info(pedidoAlmacenMapper.getPedidoAlmacen(3L).getAutorizadoPor());
	}
	
	@Test
	public void updatePedidoAlmacenAtendidoTest(){
		fechaPedido.add(Calendar.DAY_OF_MONTH, -1);
		pedidoAlmacen = new PedidoAlmacen();
		pedidoAlmacen.setPedidoId(4L);
		pedidoAlmacen.setFechaPedido(fechaPedido.getTime());
		pedidoAlmacen.setSolicitadoPor("Carlos");
		pedidoAlmacen.setEstado("pendiente");
		
		pedidoAlmacenMapper.insertPedidoAlmacen(pedidoAlmacen);
		pedidoAlmacen = null;
		pedidoAlmacen = pedidoAlmacenMapper.getPedidoAlmacen(4L);
		
		log.info(pedidoAlmacenMapper.getPedidoAlmacen(4L).getFechaPedido());
		
		fechaAtencion.add(Calendar.DAY_OF_MONTH, 2);
		pedidoAlmacen.setFechaAtencion(fechaAtencion.getTime());
		pedidoAlmacen.setAtendidoPor("Zacarias");
		pedidoAlmacen.setEstado("Atendido");
		//log.info(pedidoAlmacen.getFechaPedido());
		log.info("updatePedidoAlmacenAutorizadoTest");
		pedidoAlmacenMapper.updatePedidoAlmacenAtendido(pedidoAlmacen);
		log.info(pedidoAlmacenMapper.getPedidoAlmacen(4L).getFechaAtencion());
	}
}
