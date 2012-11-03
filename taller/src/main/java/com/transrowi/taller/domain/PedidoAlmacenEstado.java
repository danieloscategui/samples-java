package com.transrowi.taller.domain;

public enum PedidoAlmacenEstado {
	PENDIENTE, APROBADO, DESAPROBADO, ATENDIDO;
	
	@Override
	public String toString() {
		switch (this) {
		case PENDIENTE:
			return "PENDIENTE";
		case APROBADO:
			return "APROBADO";
		case DESAPROBADO:
			return "DESAPROBADO";
		case ATENDIDO:
			return "ATENDIDO";
		default:
			return null;
		}
	}
}
