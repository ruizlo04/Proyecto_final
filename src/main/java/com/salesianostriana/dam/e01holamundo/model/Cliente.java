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
>>>>>>> 33ae20dbb052e865b158075c4a89d4d2f9d0cee3
