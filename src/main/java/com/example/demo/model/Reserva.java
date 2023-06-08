package com.example.demo.model;

import java.time.LocalDate; 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ForeignKey;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_res_usu"))
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Usuario usuario;
	
	private int num_personas;
	
	public Reserva(long cod_reserva, String nombre, String email, LocalDate fecha, String tipo_evento,
			String lugar_evento, int num_personas) {
		super();
		this.cod_reserva = cod_reserva;
		this.nombre = nombre;
		this.email = email;
		this.fecha = fecha;
		this.tipo_evento = tipo_evento;
		this.lugar_evento = lugar_evento;
		this.num_personas = num_personas;
	}
	
}