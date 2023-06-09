package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_men_res"))
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Menu menu;

	public Menu(Long cod_menu, String nombre, String descripcion, double precio) {
		super();
		this.cod_menu = cod_menu;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	public String getEnumSeletor() {
		return this.nombre.concat(" ").concat(Double.toString(this.getPrecio())); 
	}
	

}
