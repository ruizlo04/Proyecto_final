package com.example.demo.model;
import java.util.Collection; 
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente implements UserDetails{
	
	@Id
	@GeneratedValue
	private Long cod_cliente;
	
	private String nombreUsuario;
	private String contrasena;
	
	private boolean admin;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = "ROLE_";
		role += (admin) ? "CLIENTE" : "USER";
		return List.of(new SimpleGrantedAuthority(role));
	}	

	@Override
	public boolean isAccountNonExpired() { 
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { 
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}