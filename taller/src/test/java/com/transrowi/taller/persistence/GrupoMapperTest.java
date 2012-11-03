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

import com.transrowi.taller.domain.Grupo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-applicationContext.xml"})
@Transactional
public class GrupoMapperTest {
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private GrupoMapper grupoMapper;
	
	private Grupo grupo;
	
	@Test
	public void getGrupoByIdTest(){
		grupo = grupoMapper.getGrupo(3);
		Assert.assertNotNull(grupo);
		Assert.assertEquals("3", grupo.toString());
		Assert.assertEquals("03", grupo.getGrupoCodigo());
		log.info(grupo.getDescripcion());
	}
	
	@Test
	public void getGrupoListTest(){
		grupo = grupoMapper.getGrupoList().get(0);
		Assert.assertNotNull(grupo);
		Assert.assertEquals(3, grupoMapper.getGrupoList().size());
		Assert.assertEquals("2",grupoMapper.getGrupoList().get(1).toString());
		log.info(grupo.getDescripcion());
		log.info(grupoMapper.getGrupoList().size());
	}
	
	@Test
	public void insertGrupoTest(){
		grupo = new Grupo();
		grupo.setGrupoId(4);
		grupo.setGrupoCodigo("04");
		grupo.setDescripcion("PERNOS");
		
		grupoMapper.insertGrupo(grupo);
		
		Assert.assertEquals("PERNOS", grupoMapper.getGrupo(4).getDescripcion());
		log.info(grupoMapper.getGrupo(4).getGrupoCodigo()+ "-"+grupoMapper.getGrupo(4).getDescripcion());
	}
	
	@Test
	public void updateGrupoTest(){
		grupo = grupoMapper.getGrupo(1);
		log.info(grupo.getDescripcion());
		grupo.setDescripcion("PERNOS CABEZA HEXAGONAL");
		grupoMapper.updateGrupo(grupo);
		Assert.assertEquals("PERNOS CABEZA HEXAGONAL", grupoMapper.getGrupo(1).getDescripcion());
		log.info(grupoMapper.getGrupo(1).getDescripcion());
	}
	
	@Test
	public void searchGrupoListTest(){
		String searchGrupo = "%to%";
		int sizeGrupoList;
		sizeGrupoList = grupoMapper.searchGrupoList(searchGrupo).size();
		Assert.assertEquals(2, sizeGrupoList);
		for (Grupo grupo : grupoMapper.searchGrupoList(searchGrupo)) {
			log.info(grupo.getDescripcion());
		}
	}
	
	@Test
	public void searchGrupoListByCodigoTest(){
		String searchGrupoCodigo = "%a01%";
		int sizeGrupoList;
		sizeGrupoList = grupoMapper.searchGrupoListByCodigo(searchGrupoCodigo).size();
		Assert.assertEquals(0, sizeGrupoList);
		for (Grupo grupo : grupoMapper.searchGrupoListByCodigo(searchGrupoCodigo)) {
			log.info(grupo.getDescripcion());
		}
	}
	
	@Test
	public void getMaxGrupoId(){
		int maxId = grupoMapper.getMaxGrupoId();
		Assert.assertEquals(3, maxId);
	}

}
