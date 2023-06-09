package com.example.demo.model;

import java.time.LocalDate; 
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ForeignKey;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data 
@NoArgsConstructor
@Table(name = "reserva")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cod_reserva;
	
	private String nombre;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	
	private String tipo_evento;
	private String lugar_evento;
	
	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "id")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Usuario usuario;
	
	private int num_personas;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_res_men"))
	@ToString.Exclude
	@EqualsAndHashCode.Exclude 
	private Menu menu;

	public Reserva(long cod_reserva, String nombre, LocalDate fecha, String tipo_evento,
			String lugar_evento, int num_personas) {
		super();
		this.cod_reserva = cod_reserva;
		this.nombre = nombre;
		this.fecha = fecha;
		this.tipo_evento = tipo_evento;
		this.lugar_evento = lugar_evento;
		this.num_personas = num_personas;
	}
	
	public double calcularTotal() {
		double total = 0.0;
		double descuento = 10;
		double cien = 100;
		if (num_personas > 25) {
			return total = menu.getPrecio() * num_personas;
		} else {
			return total = ((menu.getPrecio() * num_personas) * descuento) / cien;
		}
		
	}
}