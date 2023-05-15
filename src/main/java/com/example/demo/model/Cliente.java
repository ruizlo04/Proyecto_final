package com.example.demo.model;

<<<<<<< HEAD

import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

=======
import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
>>>>>>> f8bb319747be262fca91b401773aac5fea9b47b4
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor
<<<<<<< HEAD
=======
@AllArgsConstructor
>>>>>>> f8bb319747be262fca91b401773aac5fea9b47b4
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cod_cliente;
<<<<<<< HEAD
	
	private String nombre;
	private String dni;
	private String telefono;
	
	public Cliente(long cod_cliente, String nombre, String dni, String telefono) {
		super();
		this.cod_cliente = cod_cliente;
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
	}

	
=======
	private String nombre;
	private String dni;
	private String telefono;

>>>>>>> f8bb319747be262fca91b401773aac5fea9b47b4
}
