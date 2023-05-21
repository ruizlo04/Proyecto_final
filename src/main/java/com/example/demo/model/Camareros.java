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
public class Camareros {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cod_camarero;
	
	private String nombre;
	private String apellidos;
	private String dni;
	private String telefono;
	
	public Camareros(long cod_camarero, String nombre, String apellidos, String dni, String telefono) {
		super();
		this.cod_camarero = cod_camarero;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.telefono = telefono;
	}
	
	

}
