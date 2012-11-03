package com.transrowi.taller.persistence;

import java.util.List;


import com.transrowi.taller.domain.MovimientoAlmacenItem;


public interface MovimientoAlmacenItemMapper {

	List<MovimientoAlmacenItem> getMovimientoAlmacenItemsByMovimientoId(Long movimientoId);
	void insertMovimientoAlmacenItem(MovimientoAlmacenItem movimientoAlmacenItem);
}
