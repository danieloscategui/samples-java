package com.transrowi.taller.domain;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;


import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


public class CartItemTest {
	private Log log = LogFactory.getLog(getClass());
	
	@Test
	public void testMockito(){
		Map<String, Object> mapMock = mock(Map.class);
		
		when(mapMock.get("firstKey")).thenReturn("firstValue");
		when(mapMock.get("secondKey")).thenReturn("secondValue");
		
		Object o = new Object();
		mapMock.put("anyObject", o);
		//log.info("assertEquals");
		assertEquals("firstValue", mapMock.get("firstKey"));
		assertEquals("secondValue", mapMock.get("secondKey"));
		
		verify(mapMock).get("firstKey");
		verify(mapMock).get("secondKey");
		
		verify(mapMock).put("anyObject", o);
	}
	
	@Test
	public void iterator_will_return_hello_world(){
		//arrange
		Iterator<String> i = mock(Iterator.class);
		when(i.next()).thenReturn("Hello").thenReturn("World");
		//act
		String result = i.next()+" "+i.next();
		//assert
		assertEquals("Hello World", result);
	}
	
	@Test
	public void with_arguments(){
		Comparable c = mock(Comparable.class);
		when(c.compareTo("Test")).thenReturn(1);
		assertEquals(1, c.compareTo("Test"));
	}
	
	@Test
	public void with_unspecified_arguments(){
		Comparable c = mock(Comparable.class);
		when(c.compareTo(anyInt())).thenReturn(-1);
		assertEquals(-1, c.compareTo(45));
	}
	
	@Test(expected = IOException.class)
	public void OutputStreamWriter_rethrows_an_exception_from_OutputStream()
		throws IOException{
		OutputStream mock = mock(OutputStream.class);
		OutputStreamWriter osw = new OutputStreamWriter(mock);
		doThrow(new IOException()).when(mock).close();
		osw.close();
	}
	
	@Test
	public void OutputStreamWriter_Closes_OutputStream_on_Close()
		throws IOException{
		OutputStream mock = mock(OutputStream.class);
		OutputStreamWriter osw = new OutputStreamWriter(mock);
		osw.close();
		verify(mock).close();
	}
	
	@Test
	public void shouldReturnAnItem(){
		Item item = new Item();
		CartItem mockCartItem = mock(CartItem.class);
		
		when(mockCartItem.getItem()).thenReturn(item);
		assertSame(item, mockCartItem.getItem());
	}
	
	@Test
	public void testCalculateTotalCartItem(){
		Item item = new Item();
		CartItem cartItem = new CartItem();
		
		item.setPrecioLista(new BigDecimal("1.5"));
		cartItem.setCantidad(new BigDecimal("2.1"));
		cartItem.setItem(item);
		
		log.info(cartItem.getTotal());
		assertEquals(new BigDecimal("3.15"), cartItem.getTotal());
	}
	
	@Test
	public void testReturnNullCalculateTotalCartItem(){
		Item item = new Item();
		CartItem cartItem = new CartItem();
		
		cartItem.setCantidad(new BigDecimal("5.0"));
		cartItem.setItem(item);
		
		log.info(cartItem.getTotal());
		
		assertNull(cartItem.getTotal());
	}
	
	
}
