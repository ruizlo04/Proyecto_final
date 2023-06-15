package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
	
    
    void guardarReservaConUsuario(Reserva reserva);
    
    List<Reserva> findByUsuario(Long idCurrentUser);
}
