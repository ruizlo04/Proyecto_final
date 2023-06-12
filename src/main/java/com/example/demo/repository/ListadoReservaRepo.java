package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Reserva;

public interface ListadoReservaRepo extends JpaRepository<Reserva, Long>{

//  @Query("select r from Reserva r where r.id = ?1")
  @Query(value = "SELECT * FROM RESERVA WHERE ID = ?", nativeQuery = true)
  List<Reserva> findByUsuario(Long idCurrentUser);
}
