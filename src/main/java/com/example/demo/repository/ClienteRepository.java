package com.example.demo.repository;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;   

import com.example.demo.model.Cliente;
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	public  List<Cliente> findByNombreContainingIgnoreCase(String nombre);

}
