package com.example.demo.excepcion;

public class ExcepcionReservaVacia extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionReservaVacia() {

	}

	public ExcepcionReservaVacia(String mensaje) {

		super("No se ha realizado ninguna reserva aún");
	}
}
