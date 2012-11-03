package com.transrowi.taller.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transrowi.taller.domain.Familia;
import com.transrowi.taller.domain.Grupo;
import com.transrowi.taller.domain.Item;
import com.transrowi.taller.domain.Sequence;
import com.transrowi.taller.domain.UnidadMedida;
import com.transrowi.taller.persistence.FamiliaMapper;
import com.transrowi.taller.persistence.GrupoMapper;
import com.transrowi.taller.persistence.ItemMapper;
import com.transrowi.taller.persistence.SequenceMapper;
import com.transrowi.taller.persistence.UnidadMedidaMapper;

@Service
public class CatalogoService {
	
	@Autowired
	private GrupoMapper grupoMapper;
	@Autowired
	private FamiliaMapper familiaMapper;
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private SequenceMapper sequenceMapper;
	@Autowired
	private UnidadMedidaMapper unidadMedidaMapper;
	
	
	//TODO relacionado con clase Grupo
	public List<Grupo> getGrupoList(){
		return grupoMapper.getGrupoList();
	}
	public Grupo getGrupo(Integer grupoId){
		return grupoMapper.getGrupo(grupoId);
	}
	public List<Grupo> searchGrupoList(String keyword){
		return grupoMapper.searchGrupoList("%"+ keyword.toLowerCase() + "%");
	}
	public List<Grupo> searchGrupoListByCodigo(String keyword){
		return grupoMapper.searchGrupoListByCodigo("%"+ keyword.toLowerCase() + "%");
	}
	@Transactional
	public void insertGrupo(Grupo grupo){
		grupo.setGrupoId(Integer.valueOf(getNextId("gruponum")));
		grupoMapper.insertGrupo(grupo);
	}
	@Transactional
	public void updateGrupo(Grupo grupo){
		grupoMapper.updateGrupo(grupo);
	}
	
	public String generarCodigoGrupo() throws CatalogoException{
		Grupo grupo = grupoMapper.getGrupo(grupoMapper.getMaxGrupoId());
		return CatalogoCodigo.nextGrupoCodigo(grupo.getGrupoCodigo()); 
	}
	
	//TODO relacionaddo con la clase Familia
	/**
	 * Obtiene todas las familia de provienen de un grupo
	 * @param grupoId
	 * @return Lista de familias segun grupo
	 */
	public List<Familia> getFamiliaListByGrupo(Integer grupoId){
		return familiaMapper.getFamiliaListByGrupo(grupoId);
	}
	/**
	 * Obtiene una familia especifica segun si id
	 * @param familiaId
	 * @return Object Familia
	 */
	public Familia getFamilia(Integer familiaId){
		return familiaMapper.getFamilia(familiaId);
	}
	@Transactional
	public void insertFamilia(Familia familia){
		familia.setFamiliaId(Integer.valueOf(getNextId("familianum")));
		familiaMapper.insertFamilia(familia);
	}
	@Transactional
	public void updateFamilia(Familia familia){
		familiaMapper.updateFamilia(familia);
	}
	public List<Familia> searchFamiliaList(String keyword){
		return familiaMapper.searchFamiliaList("%"+ keyword.toLowerCase()+"%");
	}
	public List<Familia> searchFamiliaListByCodigo(String keyword){
		return familiaMapper.searchFamiliaListByCodigo("%"+keyword.toLowerCase()+"%");
	}
	
	
	public String generarCodigoFamilia(int grupoId) throws CatalogoException {
		Integer familiaId = familiaMapper.getMaxFamiliaIdByGrupo(grupoId);
		Grupo grupo = grupoMapper.getGrupo(grupoId);
		if (familiaId == null) {
			return grupo.getGrupoCodigo().concat(CatalogoCodigo.formatNumber(1, CatalogoCodigo.PATTERN_FAMILIA));
		}
		String lastedCodigoFamilia = familiaMapper.getFamilia(familiaId).getFamiliaCodigo(); 
		return CatalogoCodigo.nextFamiliaCodigo(lastedCodigoFamilia);
	}
	
	//TODO relacionado con item
	public List<Item> getItemListByFamilia(Integer familiaId){
		return itemMapper.getItemListByFamilia(familiaId);
	}
	
	public Item getItem(Integer itemId){
		return itemMapper.getItem(itemId);
	}
	
	public List<Item> getItemList(){
		return itemMapper.getItemList();
	}
	
	@Transactional
	public void insertItem(Item item){
		item.setItemId(Integer.valueOf(getNextId("itemnum")));
		itemMapper.insertItem(item);
	}
	@Transactional
	public void updateItem(Item item){
		itemMapper.updateItem(item);
	}
	
	public List<Item> searchItemList(String keyword){
		return itemMapper.searchItemList("%"+keyword.toLowerCase()+"%");
	}
	
	public List<Item> searchItemListByCodigo(String keyword){
		return itemMapper.searchItemListByCodigo("%"+keyword.toLowerCase()+"%");
	}

	public String generarCodigoItem(int familiaId) throws CatalogoException {
		Integer itemId = itemMapper.getMaxItemIdByFamilia(familiaId);
		Familia familia = familiaMapper.getFamilia(familiaId);
		if (itemId == null) {
			return familia.getFamiliaCodigo().concat(CatalogoCodigo.formatNumber(1, CatalogoCodigo.PATTERN_ITEM));
		}
		String lastedCodigoItem = itemMapper.getItem(itemId).getItemCodigo();
		return CatalogoCodigo.nextItemCodigo(lastedCodigoItem);
	}

	
	public List<UnidadMedida> getUnidadMedidaList(){
		return unidadMedidaMapper.getUnidadMedidaList();
	}
	
	
	//Metodos utiles
	private String getNextId(String name){
		Sequence sequence = new Sequence(name, -1L);
		sequence = sequenceMapper.getSequence(sequence);
		if (sequence == null){
			throw new RuntimeException("Error: La sequencia,"+name+" retornado null desde la base de datos.");
		}
		Sequence parameterObject = new Sequence(name, sequence.getNextId()+ 1L);
		sequenceMapper.updateSequence(parameterObject);
		return sequence.getNextId().toString();
	}
	
}