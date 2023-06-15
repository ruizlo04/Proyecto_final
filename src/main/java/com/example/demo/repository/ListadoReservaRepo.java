package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Reserva;

/**
 * Esta clase sirve para mostrar, mediante ua consulta, las reservas que cree un usuario, por ello utiliza el método
 * findByUsuario que busca el usuario al que esté asociado dicha reserva con el id del currentUser que es el id
 * del usuario con el que la estás realizando.
 * @author Admin
 *
 */
public interface ListadoReservaRepo extends JpaRepository<Reserva, Long>{

  @Query(value = "SELECT * FROM RESERVA WHERE ID = ?", nativeQuery = true)
  List<Reserva> findByUsuario(Long idCurrentUser);
}
