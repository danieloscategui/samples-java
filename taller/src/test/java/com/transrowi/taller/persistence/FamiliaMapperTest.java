package com.transrowi.taller.persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.transrowi.taller.domain.Familia;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-applicationContext.xml"})
@Transactional
public class FamiliaMapperTest {
	
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private FamiliaMapper familiaMapper;
	
	private Familia familia;
	
	@Test
	public void getFamiliaTest(){
		familia = familiaMapper.getFamilia(2);
		Assert.assertNotNull(familia);
		Assert.assertEquals("0102", familia.getFamiliaCodigo());
		log.info(familia.getDescripcion());
	}
	
	@Test
	public void getFamiliaListTest(){
		familia = familiaMapper.getFamiliaList().get(3);
		Assert.assertNotNull(familia);
		Assert.assertEquals("2", familia.getGrupoId().toString());
		log.info(familia.getDescripcion());
		log.info(familiaMapper.getFamiliaList().size());
	}
	
	@Test
	public void insertFamiliaTest(){
		familia = new Familia();
		familia.setFamiliaId(5);
		familia.setGrupoId(3);
		familia.setFamiliaCodigo("0301");
		familia.setDescripcion("COLAS");
		
		familiaMapper.insertFamilia(familia);
		Assert.assertEquals("5", familiaMapper.getFamilia(5).toString());
		Assert.assertEquals("0301", familiaMapper.getFamilia(5).getFamiliaCodigo());
		Assert.assertEquals("COLAS", familiaMapper.getFamilia(5).getDescripcion());
		log.info(familiaMapper.getFamilia(5).getDescripcion());
	}
	
	@Test
	public void updateFamiliaTes(){
		familia = familiaMapper.getFamilia(2);
		log.info(familia.getDescripcion());
		familia.setDescripcion("NUEVA FAMILIA");
		familiaMapper.updateFamilia(familia);
		Assert.assertEquals("NUEVA FAMILIA", familiaMapper.getFamilia(2).getDescripcion());
		log.info(familia.getDescripcion());
	}
	
	@Test
	public void searchFamiliaListTest(){
		String searchFamila = "%cables%";
		int sizeFamiliaList;
		log.info("searchFamiliaListTest");
		sizeFamiliaList = familiaMapper.searchFamiliaList(searchFamila).size();
		Assert.assertEquals(2, sizeFamiliaList);
		for (Familia familia: familiaMapper.searchFamiliaList(searchFamila)) {
			log.info(familia.getDescripcion());
		}
	} 
	
	@Test
	public void searchFamiliaListByCodigoTest(){
		String codigoFamilia = "%01%";
		int sizeFamiliList;
		log.info("SearchFamiliaListByCodigo");
		sizeFamiliList = familiaMapper.searchFamiliaListByCodigo(codigoFamilia).size();
		Assert.assertEquals(3, sizeFamiliList);
		for (Familia familia : familiaMapper.searchFamiliaListByCodigo(codigoFamilia)) {
			log.info(familia.getDescripcion());
		}
	}
	
	@Test
	public void getFamiliaListByGrupo(){
		log.info("into getFamiliaListByGrupo");
		int sizeFamiliaList;
		sizeFamiliaList = familiaMapper.getFamiliaListByGrupo(1).size();
		Assert.assertEquals(2, sizeFamiliaList);
	}
	
	@Test
	public void getMaxFamiliaIdByGrupoReturnNull(){
		Integer maxId = familiaMapper.getMaxFamiliaIdByGrupo(3);
		log.info(maxId);
		Assert.assertNull(maxId);
	}
	
	@Test
	public void getMaxFamiliaIdByGrupo(){
		Integer maxId = familiaMapper.getMaxFamiliaIdByGrupo(2);
		Integer expected = 4;
		Assert.assertEquals(expected, maxId);
	}
}
