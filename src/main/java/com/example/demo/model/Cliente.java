package com.example.demo.model;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 235005530682cace0918232ee6195bc47f4ff930

import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
=======

=======
import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
>>>>>>> f8bb319747be262fca91b401773aac5fea9b47b4
>>>>>>> 235005530682cace0918232ee6195bc47f4ff930
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
@AllArgsConstructor
>>>>>>> f8bb319747be262fca91b401773aac5fea9b47b4
>>>>>>> 235005530682cace0918232ee6195bc47f4ff930
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cod_cliente;
<<<<<<< HEAD
	
	private String nombre;
	private String apellidos;
	private String email;
	private String dni;
	private String telefono;
	
	public Cliente(long cod_cliente, String nombre,String apellidos, String email, String dni, String telefono) {
		super();
		this.cod_cliente = cod_cliente;
		this.nombre = nombre;
		this.apellidos= apellidos;
		this.email = email;
=======
<<<<<<< HEAD
	
	private String nombre;
	private String dni;
	private String telefono;
	
	public Cliente(long cod_cliente, String nombre, String dni, String telefono) {
		super();
		this.cod_cliente = cod_cliente;
		this.nombre = nombre;
>>>>>>> 235005530682cace0918232ee6195bc47f4ff930
		this.dni = dni;
		this.telefono = telefono;
	}

<<<<<<< HEAD
}
=======
	
=======
	private String nombre;
	private String dni;
	private String telefono;

>>>>>>> f8bb319747be262fca91b401773aac5fea9b47b4
}
>>>>>>> 235005530682cace0918232ee6195bc47f4ff930
