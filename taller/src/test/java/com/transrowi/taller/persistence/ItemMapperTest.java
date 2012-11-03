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

import com.transrowi.taller.domain.Item;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-applicationContext.xml"})
@Transactional
public class ItemMapperTest {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private ItemMapper itemMapper;
	
	private Item item;
	
	@Test
	public void getItemTest(){
		log.info("getItemTest");
		item = itemMapper.getItem(3);
		log.info(item.getDescripcion());
		log.info(item.getUnidadMedida().getAcronimo());
		Assert.assertNotNull(item);
		Assert.assertEquals("0201001", item.getItemCodigo());
	}
	
	@Test
	public void getItemListTest(){
		log.info("getItemListTest");
		int sizeItemList;
		sizeItemList = itemMapper.getItemList().size();
		//log.info(item.getDescripcion());
		item = itemMapper.getItemList().get(2);
		Assert.assertEquals(3, sizeItemList);
		Assert.assertEquals("0201001", item.getItemCodigo());
		Assert.assertTrue(item.getPrecioLista().equals(new BigDecimal("5.50")));
		log.info(item.getItemCodigo()+"="+item.getDescripcion());
	}
	
	@Test
	public void searchItemListTest(){
		String searchItem = "%asa%";
		int sizeItemList;
		log.info("searchItemListTeste");
		sizeItemList = itemMapper.searchItemList(searchItem).size();
		Assert.assertEquals(2, sizeItemList);
	}
	
	@Test
	public void searchItemListByCodigoTest(){
		String codigoItem = "%0101%";
		int sizeItemList;
		log.info("searchItemListByCodigo");
		sizeItemList = itemMapper.searchItemListByCodigo(codigoItem).size();
		Assert.assertEquals(2, sizeItemList);
	}
	
	@Test
	public void insertItemTest(){
		item = new Item();
		item.setItemId(4);
		item.setFamiliaId(4);
		item.setItemCodigo("0202001");
		item.setUnidadMedidaId(3);
		item.setDescripcion("NUEVO ITEM");
		item.setPrecioLista(new BigDecimal("2.60"));
		item.setCostoUnitario(new BigDecimal("1.50"));
		
		log.info("insertItemTest");
		
		itemMapper.insertItem(item);
		Assert.assertEquals("4", itemMapper.getItem(4).toString());
		
		log.info(item.getDescripcion());
	}
	
	@Test
	public void updateItemTest(){
		item = itemMapper.getItem(2);
		log.info("udpateItemTest");
		log.info(item.getDescripcion()+" - "+item.getPrecioLista()+" - "+item.getCostoUnitario());
		item.setDescripcion("new item");
		item.setPrecioLista(new BigDecimal("4.50"));
		item.setCostoUnitario(new BigDecimal("3.5"));
		Item itemTest = new Item();
		itemTest = itemMapper.getItem(2);
		itemMapper.updateItem(item);
		Assert.assertEquals(item.getDescripcion(), itemTest.getDescripcion());
		Assert.assertEquals(item.getPrecioLista(), itemTest.getPrecioLista());
		Assert.assertEquals(item.getCostoUnitario(), itemTest.getCostoUnitario());
		log.info(itemTest.getDescripcion()+" - "+itemTest.getPrecioLista()+" - "+itemTest.getCostoUnitario());
	}
	
	@Test
	public void getItemListByFamiliaTest(){
		log.info("into getItemListByFamiliaTest");
		int sizeItemList;
		sizeItemList = itemMapper.getItemListByFamilia(1).size();
		Assert.assertEquals(2, sizeItemList);
	}
	
	@Test
	public void getMaxItemIdByFamiliaReturnNull(){
		Integer maxId = itemMapper.getMaxItemIdByFamilia(2);
		Assert.assertNull(maxId);
	}
	
	@Test
	public void getMaxItemIdByFamilia(){
		Integer maxId = itemMapper.getMaxItemIdByFamilia(1);
		Integer expected = 2;
		Assert.assertEquals(expected, maxId);
	}
	
	@Test
	public void getCantidadItemId(){
		Integer itemId = 3;
		BigDecimal expected = new BigDecimal("15.00");
		BigDecimal actual = itemMapper.getInventoryQuantity(itemId);
		log.info("actual: "+ actual);
		Assert.assertEquals(expected, actual);
	}
}
