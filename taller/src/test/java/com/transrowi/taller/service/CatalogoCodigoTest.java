package com.transrowi.taller.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import static org.junit.Assert.*;

public class CatalogoCodigoTest {
	private Log log = LogFactory.getLog(getClass());
	
		
	@Test
	public void testFormatNumberGrupo(){
		log.info("tesing testformatnumbergrupo");
		String expected = "05";
		String actual = CatalogoCodigo.formatNumber(5, CatalogoCodigo.PATTERN_GRUPO);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFormatNumberFamilia(){
		log.info("testing testformatnumberfamilia");
		String expected = "04";
		String actual = CatalogoCodigo.formatNumber(4, CatalogoCodigo.PATTERN_FAMILIA);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFormatNumberItem(){
		log.info("testing testformatnumberitem");
		String expected = "114";
		String actual = CatalogoCodigo.formatNumber(114, CatalogoCodigo.PATTERN_ITEM);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testNextGrupoCodigo(){
		log.info("testing testNextGrupoCodigo");
		String lastedCodigo = "98";
		String expected = "99";
		String actual = null;
		try {
			actual = CatalogoCodigo.nextGrupoCodigo(lastedCodigo);
		} catch (CatalogoException e) {
			// TODO Auto-generated catch block
			log.info(e.getMessage());
		}
		assertEquals(expected, actual);
	}
	
	@Test
	public void testNextFamiliaCodigo(){
		log.info("testing testNextFamiliaCodigo");
		String lastedCodigo = "5101";
		String expected = "5102";
		String actual = null;
		try {
			actual = CatalogoCodigo.nextFamiliaCodigo(lastedCodigo);
		} catch (CatalogoException e) {
			// TODO Auto-generated catch block
			log.info(e.getMessage());
		}
		assertEquals(expected, actual);
	}
	
	@Test
	public void testNextItemCodigo(){
		log.info("testing testNextItemCodigo");
		String lastedCodigo = "5105123";
		String expected = "5105124";
		String actual = null;
		try {
			actual = CatalogoCodigo.nextItemCodigo(lastedCodigo);
		} catch (CatalogoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(expected, actual);
	}
	
	@Test (expected = CatalogoException.class)
	public void testGrupoCodigoMaximoSuperado() throws CatalogoException{
		log.info("testing testGrupoCodigoMaximoSuperado");
		String lastedCodigo = "99";
		CatalogoCodigo.nextGrupoCodigo(lastedCodigo);
	}
	
	@Test(expected = CatalogoException.class)
	public void testFamiliaCodigoMaximoSuperado() throws CatalogoException{
		log.info("testing testFamiliaCodigoMaximoSuperado");
		String lastedCodigo = "0199";
		CatalogoCodigo.nextFamiliaCodigo(lastedCodigo);
	}
	
	@Test(expected = CatalogoException.class)
	public void testItemCodigoMaximoSuperado() throws CatalogoException{
		log.info("testing testItemCodigoMaximoSuperado");
		String lastedCodigo = "0101999";
		CatalogoCodigo.nextItemCodigo(lastedCodigo);
	}
	
	
	
}
