package com.transrowi.taller.persistence;

import java.util.List;

import com.transrowi.taller.domain.PedidoAlmacenItem;


public interface PedidoAlmacenItemMapper {

	List<PedidoAlmacenItem> getPedidoAlmacenItemsByPedidoId(Long pedidoId);
	void insertPedidoAlmacenItem(PedidoAlmacenItem pedidoAlmacenItem);
	void updatePedidoAlmacenItemAutorizado(PedidoAlmacenItem pedidoAlmacenItem);
	void updatePedidoAlmacenItemAtendido(PedidoAlmacenItem pedidoAlmacenItem);
}
