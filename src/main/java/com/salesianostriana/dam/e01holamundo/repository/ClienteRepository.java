package com.salesianostriana.dam.e01holamundo.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.salesianostriana.dam.e01holamundo.model.Cliente;
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}

