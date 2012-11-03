package com.transrowi.taller.persistence;

import java.math.BigDecimal;
import java.util.List;

import com.transrowi.taller.domain.Item;

public interface AlmacenMapper {
	
	Item getItem(Integer itemId);

	List<Item> getItemList();

	List<Item> searchItemList(String keywords);

	BigDecimal getInventoryQuantity(Integer itemId);
}
