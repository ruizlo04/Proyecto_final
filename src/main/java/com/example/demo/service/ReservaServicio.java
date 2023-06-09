package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Menu;
import com.example.demo.model.Reserva;
import com.example.demo.repository.ReservaRepository;


@Service
public class ReservaServicio {
	
	private ReservaRepository reservaRepository;
	
	public ReservaServicio(ReservaRepository repo) {
		this.reservaRepository = repo;
	}
	
	/**
	 * Inserta un nuevo Cliente
	 * 
	 * @param c el Cliente a insertar
	 * @return El cliente ya insertado (con el Id no vacío).
	 */
	public Reserva add(Reserva r) { return reservaRepository.save(r); }
	
	
	/**
	 * Edita un cliente, si existe; si no, lo inserta como uno nuevo.
	 * @param c
	 * @return
	 */
	public Reserva edit(Reserva r) { return reservaRepository.save(r); }

	/**
	 * Elimina el cliente
	 * 
	 * @param c
	 */
	public void delete(Reserva r) { reservaRepository.delete(r); }
	
	/**
	 * Elimina a un cliente por su Id
	 * @param id
	 */
	public void delete(long id) { reservaRepository.deleteById(id); }
	
	/**
	 * Devuelve todos los clientes
	 * @return
	 */
	public List<Reserva> findAll() { return reservaRepository.findAll(); }
	
	
	/**
	 * Devuelve un cliente en base a su Id
	 * @param id
	 * @return el cliente encontrado o <code>null</code>
	 */
	public Reserva findById(long id) {
		return reservaRepository.findById(id).orElse(null);
	}
	

}
