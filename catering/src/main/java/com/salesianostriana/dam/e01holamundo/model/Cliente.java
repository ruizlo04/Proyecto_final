<<<<<<< HEAD
package com.salesianostriana.dam.e01holamundo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
	
	@Id
	@GeneratedValue
	private long cod_cliente;
	private String nombre;
	private String dni;
	private int telefono;

}
=======
package com.salesianostriana.dam.e01holamundo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
	
	@Id
	@GeneratedValue
	private long cod_cliente;
	private String nombre;
	private String dni;
	private int telefono;

}
>>>>>>> f8bb319747be262fca91b401773aac5fea9b47b4
