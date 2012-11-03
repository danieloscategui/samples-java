package com.transrowi.taller.domain;

import java.math.BigDecimal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;




public class CartTest {
	private Log log = LogFactory.getLog(getClass());
	
	private Cart testCart;
	private Item item;
	private Item item_2;
	private final BigDecimal CANTIDAD = new BigDecimal("5.0");
	private final BigDecimal CANTIDAD_2 = new BigDecimal("4.0");
	private final BigDecimal PRECIO_LISTA = new BigDecimal("1.5");
	private final BigDecimal PRECIO_LISTA_2 = new BigDecimal("3.0");

	@Before
	public void setUp(){
		item = new Item();
		item.setItemId(1);
		item.setPrecioLista(PRECIO_LISTA);
		
		item_2 = new Item();
		item_2.setItemId(2);
		item_2.setPrecioLista(PRECIO_LISTA_2);
	}
	
	@Test
	public void testAddItemToCart(){
		log.info("Into in testAddItemToCart");
		testCart = new Cart();
		testCart.addItem(item, true);
		assertEquals(1, testCart.getNumberOfItems());
	}
	
	@Test
	public void testContainsItemId(){
		log.info("Into testContainsItemId");
		testCart = new Cart();
		testCart.addItem(item, true);
		assertTrue(testCart.containsItemId(1));
	} 
	
	@Test
	public void testNotContainsItemId(){
		log.info("Into testNotConstainsItemId");
		testCart = new Cart();
		testCart.addItem(item, true);
		assertFalse(testCart.containsItemId(2));
	}
	
	@Test
	public void testCartEmptyCartItems(){
		log.info("into testCartEmpty");
		testCart = new Cart();
		assertEquals(0, testCart.getNumberOfItems());
	}
	
	@Test
	public void testRemoveItemOfCart(){
		log.info("into testRemoveItemOfCart");
		testCart = new Cart();
		testCart.addItem(item, true);
		testCart.addItem(item_2, true);
		
		assertEquals(2, testCart.getNumberOfItems());
		testCart.removeItemById(1);
		assertEquals(1, testCart.getNumberOfItems());
		assertFalse(testCart.containsItemId(1));
		
	}
	
	@Test
	public void testSubTotalCart(){
		log.info("into testSubTotalCart");
		
		testCart = new Cart();
		testCart.addItem(item, true);
		testCart.addItem(item, true);
		testCart.addItem(item_2, true);
		
		testCart.setCantidadByItemId(item.getItemId(), CANTIDAD_2);
		testCart.setCantidadByItemId(item_2.getItemId(), CANTIDAD);
		
		assertEquals(new BigDecimal("21.00"), testCart.getSubTotal());
		log.info(testCart.getSubTotal().toString());
	}
	
	@Test
	public void testIncrementCartItemByItemId(){
		log.info("into testIncrementCartItemByItemId");
		
		testCart = new Cart();
		testCart.addItem(item, true);
		
		assertEquals(new BigDecimal("1.00"), testCart.getCartItemList().get(0).getCantidad());
		
		testCart.incrementCantidaByItemId(item.getItemId());
		
		assertEquals(new BigDecimal("2.00"), testCart.getCartItemList().get(0).getCantidad());
	}
	
}
