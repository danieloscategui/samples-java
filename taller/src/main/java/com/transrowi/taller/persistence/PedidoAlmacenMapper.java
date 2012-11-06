package com.transrowi.taller.persistence;

import java.util.List;

import com.transrowi.taller.domain.PedidoAlmacen;


public interface PedidoAlmacenMapper {

	PedidoAlmacen getPedidoAlmacen(Long pedidoId);
	void insertPedidoAlmacen(PedidoAlmacen pedidoAlmacen);
	void updatePedidoAlmacenAutorizado(PedidoAlmacen pedidoAlmacen);
	void updatePedidoAlmacenAtendido(PedidoAlmacen pedidoAlmacen);
	List<PedidoAlmacen> getPedidoAlmacenByEstado(String estado);
}
