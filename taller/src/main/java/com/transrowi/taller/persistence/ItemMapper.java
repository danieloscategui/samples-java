package com.transrowi.taller.persistence;

import java.math.BigDecimal;
import java.util.List;

import com.transrowi.taller.domain.Item;

public interface ItemMapper {
	Item getItem(Integer itemId);

	List<Item> getItemList();

	List<Item> searchItemList(String keywords);

	List<Item> searchItemListByCodigo(String keywords);
	
	List<Item> getItemListByFamilia(Integer familiaId);

	void insertItem(Item item);
	
	void updateItem(Item item);
	
	Integer getMaxItemIdByFamilia(int familiaId);

	BigDecimal getInventoryQuantity(Integer itemId);
}
