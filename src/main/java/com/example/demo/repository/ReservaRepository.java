package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
	
    
    void guardarReservaConUsuario(Reserva reserva);
    
//    @Query("select r from Reserva r where r.id = ?1")
//    @Query(value = "SELECT * FROM RESERVA WHERE ID = ?0", nativeQuery = true)
    List<Reserva> findByUsuario(Long idCurrentUser);
}
