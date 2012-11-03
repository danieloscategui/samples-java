package com.transrowi.taller.persistence;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.transrowi.taller.domain.UnidadMedida;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
@Transactional
public class UnidadMedidaMapperTest {
	
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private UnidadMedidaMapper unidadMedidaMapper;
	
	private UnidadMedida unidadMedida;
	
	@Test
	public void getUnidadMedidaTest(){
		unidadMedida = unidadMedidaMapper.getUnidadMedida(1);
		log.info("getUnidadMedidaTest");
		Assert.assertNotNull(unidadMedida);
		log.info(unidadMedida.getDescripcion());
	}
	
	@Test
	public void getUnidadMedidaListTest(){
		log.info("getUnidadMedidaListTest");
		int sizeUnidadMedidaList;
		sizeUnidadMedidaList = unidadMedidaMapper.getUnidadMedidaList().size();
		Assert.assertEquals(3, sizeUnidadMedidaList);
		log.info(unidadMedidaMapper.getUnidadMedidaList().get(2).getUnidadMedidaId());
		log.info(unidadMedidaMapper.getUnidadMedidaList().get(2).getDescripcion());
	}
	
	@Test
	public void searchUnidadMedidaListTest(){
		log.info("searchUnidadMedidaListTest");
		String searchUnidadMedida = "%met%";
		int sizeUnidadMedidaList;
		sizeUnidadMedidaList = unidadMedidaMapper.searchUnidadMedidaList(searchUnidadMedida).size();
		Assert.assertEquals(1, sizeUnidadMedidaList);
		log.info(unidadMedidaMapper);
	}
}
