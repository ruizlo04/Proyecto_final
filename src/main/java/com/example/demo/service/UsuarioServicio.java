package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.model.Reserva;
import com.example.demo.model.Usuario;
import com.example.demo.repository.ReservaRepository;
import com.example.demo.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * La clase UsuarioServicio es un servicio que proporciona métodos para agregar, editar, eliminar y
 * buscar usuarios y reservas en la base de datos. También utiliza la clase PasswordEncoder para 
 * codificar las contraseñas de los usuarios antes de almacenarlas en la base de datos. Además, el
 * método guardarReserva se encarga de guardar una reserva asociada a un usuario en la base de datos.
 * @author Admin
 *
 */
@Service
@RequiredArgsConstructor
public class UsuarioServicio {
	
	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;
	private final ReservaRepository reservaRepository;
	
	/**
	 * Este método agrega un nuevo objeto Usuario a la base de datos. Primero,
	 * codifica la contraseña del usuario utilizando el PasswordEncoder, y 
	 * luego lo guarda en la base de datos utilizando el método save de UsuarioRepository.
	 * @param u Se le pasa el usuario
	 * @return Devuelve el usuario guardado
	 */
	public Usuario add(Usuario u) { 
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return usuarioRepository.save(u); 
	}
	
	public Usuario edit(Usuario u) { 
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return usuarioRepository.save(u); }

	public void delete(Usuario u) { usuarioRepository.delete(u); }
	
	public void delete(long id) { usuarioRepository.deleteById(id); }
	
	public List<Usuario> findAll() { return usuarioRepository.findAll(); }
	
	public Usuario findById(long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	public Usuario findByUsername(String username) {
		return usuarioRepository.findFirstByUsername(username).get();
	}
	
	@Transactional
	public void guardarReserva(Reserva reserva, Usuario usuario) {
	    if (usuario.getId() == null) {
	        usuarioRepository.save(usuario);
	    }

	    reserva.setUsuario(usuario);

	    reservaRepository.save(reserva);
	}


}
