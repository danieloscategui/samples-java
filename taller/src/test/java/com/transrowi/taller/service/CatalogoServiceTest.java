package com.transrowi.taller.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.transrowi.taller.domain.Familia;
import com.transrowi.taller.domain.Grupo;
import com.transrowi.taller.domain.Item;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
@Transactional
public class CatalogoServiceTest {
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private CatalogoService catalogoService;
	
	@Test
	public void testSizeGrupoList(){
		log.info("testing testSizeGrupoList");
		int sizeGrupoList;
		sizeGrupoList = catalogoService.getGrupoList().size();
		assertEquals(3, sizeGrupoList);
	}
	
	@Test
	public void testGetGrupo(){
		log.info("testing testGetGrupo");
		Grupo grupo;
		
		grupo = catalogoService.getGrupo(2);
		
		assertNotNull(grupo);
	}
	
	@Test
	public void testSizeSearchGrupoList(){
		log.info("testing testSizeSearchGrupoList");
		int sizeSearchGrupoList;
		sizeSearchGrupoList = catalogoService.searchGrupoList("PeGa").size();
		
		assertEquals(1, sizeSearchGrupoList);
	}
	
	@Test
	public void testSizeSearchGrupoListByCodigo(){
		log.info("testing testSizeSearchGrupoList");
		int sizeSearchGrupoList;
		sizeSearchGrupoList = catalogoService.searchGrupoListByCodigo("01").size();
		
		assertEquals(1, sizeSearchGrupoList);
	}
	
	@Test
	public void testSizeGetFamiliaListByGrupo(){
		log.info("testing testSizeGetFamiliaListByGrupo");
		int sizeSearchFamiliaList;
		sizeSearchFamiliaList = catalogoService.getFamiliaListByGrupo(1).size();
		
		assertEquals(2, sizeSearchFamiliaList);
	}
	
	@Test
	public void testGetFamilia(){
		log.info("testing testGetFamilia");
		Familia familia;
		familia = catalogoService.getFamilia(1);
		
		assertNotNull(familia);
	}
	
	@Test
	public void testSizeSearchFamiliaList(){
		log.info("testing testSizeSearchFamiliaList");
		int sizeSearchFamiliaList;
		sizeSearchFamiliaList = catalogoService.searchFamiliaList("cabl").size();
		
		assertEquals(2, sizeSearchFamiliaList);
	}
	
	@Test
	public void testSizeSearchFamiliaListByCodigo(){
		log.info("testing testSizeSearchFamiliaList");
		int sizeSearchFamiliaList;
		sizeSearchFamiliaList = catalogoService.searchFamiliaListByCodigo("%02").size();
		
		assertEquals(3, sizeSearchFamiliaList);
	}
	
	@Test
	public void testGetItemListByFamilia(){
		log.info("testing testGetItemListByFamilia");
		int sizeItemList;
		sizeItemList = catalogoService.getItemListByFamilia(1).size();
		
		assertEquals(2, sizeItemList);
	}
	
	@Test
	public void testGetItem(){
		log.info("testing testGetItem");
		Item item;
		item = catalogoService.getItem(3);
		
		assertNotNull(item);
	}
	
	@Test
	public void testSearchItemList(){
		log.info("testing testSearchItemList");
		int sizeItemList;
		sizeItemList = catalogoService.searchItemList("te").size();
		
		assertEquals(2, sizeItemList);
	}
	
	@Test
	public void testSearchItemListByCodigo(){
		log.info("testing testSearchItemListByCodigo");
		int sizeItemList;
		sizeItemList = catalogoService.searchItemListByCodigo("02%01").size();
		
		assertEquals(1, sizeItemList);
	}
	
	/**
	 * Test insert and update
	 */
	@Test
	public void testInsertGrupo(){
		log.info("testing testInsertGrupo");
		
		Grupo grupo = new Grupo();
		grupo.setGrupoId(4);
		grupo.setDescripcion("descripcion");
		grupo.setGrupoCodigo("04");
		log.info("grupoCodigo: "+grupo.getGrupoCodigo());
		catalogoService.insertGrupo(grupo);
		log.info("grupoCodigo: "+catalogoService.getGrupo(4).getGrupoCodigo());

		assertEquals("04", catalogoService.getGrupo(4).getGrupoCodigo());
	}
	
	@Test
	public void testUpdateGrupo(){
		log.info("testing testUpdateGrupo");
		Grupo grupo;
		grupo = catalogoService.getGrupo(3);
		log.info("Descripcion: "+grupo.getDescripcion());
		grupo.setDescripcion("PERNOS");
		catalogoService.updateGrupo(grupo);
		log.info("Descripcion: "+catalogoService.getGrupo(3).getDescripcion());
		assertEquals("PERNOS", catalogoService.getGrupo(3).getDescripcion());
	}

}
