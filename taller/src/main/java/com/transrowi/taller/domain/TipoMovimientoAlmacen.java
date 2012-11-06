package com.transrowi.taller.domain;

public enum TipoMovimientoAlmacen {
	ENTRADA , SALIDA;
	
	public Integer getValue(){
		switch (this) {
		case ENTRADA:
			return 1;
		case SALIDA:
			return 2;
		default:
			return null;
		}
	}
	
	/*
	public String toString() {
		switch (this) {
		case ENTRADA:
			return "ENTRADA";
		case SALIDA:
			return "SALIDA";
		default:
			return null;
		}

	};*/
}
