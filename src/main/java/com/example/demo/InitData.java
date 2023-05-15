package com.example.demo;

<<<<<<< HEAD
import java.util.List;

import javax.annotation.PostConstruct;
=======
import java.util.List; 
>>>>>>> f8bb319747be262fca91b401773aac5fea9b47b4

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

<<<<<<< HEAD
=======
import jakarta.annotation.PostConstruct;
>>>>>>> f8bb319747be262fca91b401773aac5fea9b47b4
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitData {
	
	private final UsuarioRepository repo;
	private final PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void init() {
		
		Usuario usuario = Usuario.builder()
				.admin(false)
				.username("user")
				//.password("1234")
				.password(passwordEncoder.encode("1234"))
				.build();
		
		Usuario admin = Usuario.builder()
				.admin(true)
				.username("admin")
				.password(passwordEncoder.encode("admin"))
				.build();
		
		repo.saveAll(List.of(usuario, admin));
		
	}

}
