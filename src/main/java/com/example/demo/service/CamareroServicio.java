package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Camareros;
import com.example.demo.repository.CamareroRepository;

@Service
public class CamareroServicio {
	
	private CamareroRepository camareroRepository;
	
	public CamareroServicio(CamareroRepository repo) {
		this.camareroRepository = repo;
	}
	
	/**
	 * Inserta un nuevo Camarero
	 * 
	 * @param c el Camarero a insertar
	 * @return El camarero ya insertado (con el Id no vacío).
	 */
	public Camareros add(Camareros c) { return camareroRepository.save(c); }
	
	
	/**
	 * Edita un camarero, si existe; si no, lo inserta como uno nuevo.
	 * @param c
	 * @return
	 */
	public Camareros edit(Camareros c) { return camareroRepository.save(c); }

	/**
	 * Elimina el camarero
	 * 
	 * @param c
	 */
	public void delete(Camareros c) { camareroRepository.delete(c); }
	
	/**
	 * Elimina a un camarero por su Id
	 * @param id
	 */
	public void delete(long id) { camareroRepository.deleteById(id); }
	
	/**
	 * Devuelve todos los camarero
	 * @return
	 */
	public List<Camareros> findAll() { return camareroRepository.findAll(); }
	
	
	/**
	 * Devuelve un camarero en base a su Id
	 * @param id
	 * @return el camarero encontrado o <code>null</code>
	 */
	public Camareros findById(long id) {
		return camareroRepository.findById(id).orElse(null);
	}


}
