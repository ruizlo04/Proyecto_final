package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cod_reserva;
	
	private String nombre;
	private String email;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	
	private String tipo_evento;
	private String lugar_evento;
	
	public Reserva(long cod_reserva, String nombre, String email, LocalDate fecha, String tipo_evento,
			String lugar_evento) {
		super();
		this.cod_reserva = cod_reserva;
		this.nombre = nombre;
		this.email = email;
		this.fecha = fecha;
		this.tipo_evento = tipo_evento;
		this.lugar_evento = lugar_evento;
	}
	
}