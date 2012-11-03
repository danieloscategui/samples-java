package com.transrowi.taller.persistence;

import com.transrowi.taller.domain.PedidoAlmacen;


public interface PedidoAlmacenMapper {

	PedidoAlmacen getPedidoAlmacen(Long pedidoId);
	void insertPedidoAlmacen(PedidoAlmacen pedidoAlmacen);
	void updatePedidoAlmacenAutorizado(PedidoAlmacen pedidoAlmacen);
	void updatePedidoAlmacenAtendido(PedidoAlmacen pedidoAlmacen);
}
