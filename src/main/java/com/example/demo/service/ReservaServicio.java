package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Reserva;
import com.example.demo.model.Usuario;
import com.example.demo.repository.ListadoReservaRepo;
import com.example.demo.repository.ReservaRepository;


@Service
public class ReservaServicio {
	
	private ReservaRepository reservaRepository;
	
	private ListadoReservaRepo repo2;
	
	public ReservaServicio(ReservaRepository repo,ListadoReservaRepo repo2) {
		this.reservaRepository = repo;
		this.repo2 = repo2;
	}
	
	public Reserva add(Reserva r) { 
		return reservaRepository.save(r); 
		}
	
	public Reserva edit(Reserva r) { return reservaRepository.save(r); }

	public void delete(Reserva r) { reservaRepository.delete(r); }
	
	public void delete(long id) { reservaRepository.deleteById(id); }
	
	public List<Reserva> findAll() { return reservaRepository.findAll(); }
	
	public Reserva findById(long id) {
		return reservaRepository.findById(id).orElse(null);
	}
	
	public List<Reserva> findByNombre(Long idCurrentUser) {
		return repo2.findByUsuario(idCurrentUser);
	}
	
	@Transactional
	public void guardarReservaConUsuario(Reserva reserva) {
		reservaRepository.guardarReservaConUsuario(reserva);
	}

}
