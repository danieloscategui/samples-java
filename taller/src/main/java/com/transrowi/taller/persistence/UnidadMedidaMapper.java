package com.transrowi.taller.persistence;

import java.util.List;

import com.transrowi.taller.domain.UnidadMedida;

public interface UnidadMedidaMapper {
	UnidadMedida getUnidadMedida(Integer unidadMedidaId);
	List<UnidadMedida> getUnidadMedidaList();
	List<UnidadMedida> searchUnidadMedidaList(String keywords);
	void insertUnidadMedida(UnidadMedida unidadMedida);
	void updateUnidadMedida(UnidadMedida unidadMedida);
}
