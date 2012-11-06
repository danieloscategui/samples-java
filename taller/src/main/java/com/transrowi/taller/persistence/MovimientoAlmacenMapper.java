package com.transrowi.taller.persistence;

import com.transrowi.taller.domain.MovimientoAlmacen;


public interface MovimientoAlmacenMapper {

	MovimientoAlmacen getMovimientoAlmacen(Long movimientoId);
	void insertMovimientoAlmacen(MovimientoAlmacen movimientoAlmacen);
	Long getCorrelativo(int  tipoMovimiento);
}
