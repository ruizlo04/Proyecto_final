package com.example.demo.service;

import java.util.List; 
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {
	
	private UsuarioRepository usuarioRepository;
	
	public UsuarioServicio(UsuarioRepository repo) {
		this.usuarioRepository = repo;
	}
	
	/**
	 * Inserta un nuevo Usuario	
	 * 
	 * @param u el Usuario a insertar
	 * @return El usuario ya insertado (con el Id no vacío).
	 */
	public Usuario add(Usuario u) { 
		return usuarioRepository.save(u); 
	}
	
	
	/**
	 * Edita un usuario, si existe; si no, lo inserta como uno nuevo.
	 * @param u
	 * @return
	 */
	public Usuario edit(Usuario u) { return usuarioRepository.save(u); }

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

}
