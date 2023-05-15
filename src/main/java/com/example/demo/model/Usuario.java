package com.example.demo.model;

import java.util.Collection;
import java.util.List;

<<<<<<< HEAD
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

=======
>>>>>>> f8bb319747be262fca91b401773aac5fea9b47b4
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

<<<<<<< HEAD
=======
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
>>>>>>> f8bb319747be262fca91b401773aac5fea9b47b4
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD

=======
>>>>>>> f8bb319747be262fca91b401773aac5fea9b47b4
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario implements UserDetails{

	@Id
	@GeneratedValue
	private Long id;
	
	private String username, password;
	
	private boolean admin;
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = "ROLE_";
		role += (admin) ? "ADMIN" : "USER";
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
<<<<<<< HEAD
	public boolean isCredentialsNonExpired() { 
=======
	public boolean isCredentialsNonExpired() {
>>>>>>> f8bb319747be262fca91b401773aac5fea9b47b4
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
