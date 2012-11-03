package com.transrowi.taller.persistence;

import java.util.List;

import com.transrowi.taller.domain.Familia;

public interface FamiliaMapper {

	Familia getFamilia(Integer familiaId);
	void insertFamilia(Familia familia);
	void updateFamilia(Familia familia);
	Integer getMaxFamiliaIdByGrupo(int grupoId);
	List<Familia> getFamiliaList();
	List<Familia> searchFamiliaList(String keywords);
	List<Familia> searchFamiliaListByCodigo(String keywords);
	List<Familia> getFamiliaListByGrupo(Integer grupoId);
	
}
