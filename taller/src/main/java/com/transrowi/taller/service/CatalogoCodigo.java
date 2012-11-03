package com.transrowi.taller.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;



public class CatalogoCodigo {
	
	//private Log log = LogFactory.getLog(getClass());
	
	public static final String PATTERN_GRUPO = "00";
	public static final String PATTERN_FAMILIA = "00";
	public static final String PATTERN_ITEM = "000";
	
	private static final int GRUPO_MAX = 99;
	private static final int FAMILIA_MAX = 99;
	private static final int ITEM_MAX = 999;
	
	public static String formatNumber(int number, String pattern){
		NumberFormat numberFormat = new DecimalFormat(pattern);
		return numberFormat.format(number);
	}

	public static String nextGrupoCodigo(String lastedCodigo)
		throws CatalogoException{
		
		//parsear string hacia int
		int numberCode = Integer.valueOf(lastedCodigo);
		//incrementar 1
		if (numberCode == GRUPO_MAX) {throw new CatalogoException("Codigo Grupo: Maximo superado.");}
		numberCode++;
		//return nuevo codigo
		return formatNumber(numberCode, PATTERN_GRUPO);
	}

	public static String nextFamiliaCodigo(String lastedCodigo) 
		throws CatalogoException{
		//substring
		String codigoGrupo = lastedCodigo.substring(0, 2);
		String codigoFamilia = lastedCodigo.substring(2);
		int numberCode = Integer.valueOf(codigoFamilia);
		if (numberCode == FAMILIA_MAX){throw new CatalogoException("Codigo Familia: Maximo superado.");}
		numberCode++;
		
		return codigoGrupo.concat(formatNumber(numberCode, PATTERN_FAMILIA));
	}

	public static String nextItemCodigo(String lastedCodigo) 
		throws CatalogoException{
		String codigoFamilia = lastedCodigo.substring(0, 4);
		String codigoItem = lastedCodigo.substring(4);
		int numberCode = Integer.valueOf(codigoItem);
		if (numberCode == ITEM_MAX){throw new CatalogoException("Codigo Item: Maximo Superado");}
		numberCode++;
		
		return codigoFamilia.concat(formatNumber(numberCode, PATTERN_ITEM));
	}
	
	
}
