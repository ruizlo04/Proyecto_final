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

@Service
@RequiredArgsConstructor
public class UsuarioServicio {
	
	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;
	private final ReservaRepository reservaRepository;
	
	/**
	 * Inserta un nuevo Usuario	
	 * 
	 * @param u el Usuario a insertar
	 * @return El usuario ya insertado (con el Id no vacío).
	 */
	public Usuario add(Usuario u) { 
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return usuarioRepository.save(u); 
	}
	
	
	/**
	 * Edita un usuario, si existe; si no, lo inserta como uno nuevo.
	 * @param u
	 * @return
	 */
	public Usuario edit(Usuario u) { 
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return usuarioRepository.save(u); }

	/**
	 * Elimina el usuario
	 * 
	 * @param u
	 */
	public void delete(Usuario u) { usuarioRepository.delete(u); }
	
	/**
	 * Elimina a un usuario por su Id
	 * @param id
	 */
	public void delete(long id) { usuarioRepository.deleteById(id); }
	
	/**
	 * Devuelve todos los usuarios
	 * @return
	 */
	public List<Usuario> findAll() { return usuarioRepository.findAll(); }
	
	
	/**
	 * Devuelve un usuario en base a su Id
	 * @param id
	 * @return el usuario encontrado o <code>null</code>
	 */
	public Usuario findById(long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	@Transactional
	public void guardarReserva(Reserva reserva, Usuario usuario) {
	    if (usuario.getId() == null) {
	        usuarioRepository.save(usuario);
	    }

	    // Asigna el usuario a la reserva
	    reserva.setUsuario(usuario);

	    // Guarda la reserva
	    reservaRepository.save(reserva);
	}


}
