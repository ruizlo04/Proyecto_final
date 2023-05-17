package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod_menu;
	
	private String nombre;
	private String descripcion;
	private double precio;

	public Menu(Long cod_menu, String nombre, String descripcion, double precio) {
		super();
		this.cod_menu = cod_menu;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	

}
