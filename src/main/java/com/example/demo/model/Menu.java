package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data 
@NoArgsConstructor
@Table(name = "menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod_menu;
	
	private String nombre;
	private String descripcion;
	private double precio;
	
	@OneToMany(
			mappedBy = "menu", 
			fetch = FetchType.EAGER,
			cascade = CascadeType.REMOVE)
	private List<Reserva> reservas;

	public Menu(Long cod_menu, String nombre, String descripcion, double precio) {
		super();
		this.cod_menu = cod_menu;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	public String getEnumSeletor() {
		return this.nombre.concat(" - ").concat(Double.toString(this.getPrecio())); 
	}
	
	
}
