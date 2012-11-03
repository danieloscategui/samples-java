package com.transrowi.taller.domain;

public enum TipoMovimientoAlmacen {
	ENTRADA, SALIDA;
	public String toString() {
		switch (this) {
		case ENTRADA:
			return "ENTRADA";
		case SALIDA:
			return "SALIDA";
		default:
			return null;
		}

	};
}
