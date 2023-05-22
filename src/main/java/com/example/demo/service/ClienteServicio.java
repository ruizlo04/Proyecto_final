package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteServicio {
	
	private ClienteRepository clienteRepository;
	
	public ClienteServicio(ClienteRepository repo) {
		this.clienteRepository = repo;
	}
	
	/**
	 * Inserta un nuevo Cliente
	 * 
	 * @param c el Cliente a insertar
	 * @return El cliente ya insertado (con el Id no vacío).
	 */
	public Cliente add(Cliente c) { return clienteRepository.save(c); }
	
	
	/**
	 * Edita un cliente, si existe; si no, lo inserta como uno nuevo.
	 * @param c
	 * @return
	 */
	public Cliente edit(Cliente c) { return clienteRepository.save(c); }

	/**
	 * Elimina el cliente
	 * 
	 * @param c
	 */
	public void delete(Cliente c) { clienteRepository.delete(c); }
	
	/**
	 * Elimina a un cliente por su Id
	 * @param id
	 */
	public void delete(long id) { clienteRepository.deleteById(id); }
	
	/**
	 * Devuelve todos los clientes
	 * @return
	 */
	public List<Cliente> findAll() { return clienteRepository.findAll(); }
	
	
	/**
	 * Devuelve un cliente en base a su Id
	 * @param id
	 * @return el cliente encontrado o <code>null</code>
	 */
	public Cliente findById(long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	public List<Cliente> findAllProducts() {
		return clienteRepository.findAll();
	}
	
	public List<Cliente> findByNombre(String nombre){
		return clienteRepository.findByNombreContainingIgnoreCase(nombre);
	}
}
