package com.transrowi.taller.persistence;

import java.util.List;

import com.transrowi.taller.domain.Grupo;

public interface GrupoMapper {
	
	Grupo getGrupo(Integer grupoid);
	
	void insertGrupo(Grupo grupo);
	
	void updateGrupo(Grupo grupo);
	
	List<Grupo> getGrupoList();

	List<Grupo> searchGrupoList(String keywords);
	
	List<Grupo> searchGrupoListByCodigo(String keywords);
	
	Integer getMaxGrupoId();
}
