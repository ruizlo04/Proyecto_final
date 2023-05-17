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
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cod_cliente;
	
	private String nombre;
	private String apellidos;
	private String email;
	private String dni;
	private String telefono;
	
	public Cliente(long cod_cliente, String nombre, String apellidos, String email, String dni, String telefono) {
		super();
		this.cod_cliente = cod_cliente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.dni = dni;
		this.telefono = telefono;
	}
	

}