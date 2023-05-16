package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

<<<<<<< HEAD
=======
<<<<<<< HEAD

=======
>>>>>>> f8bb319747be262fca91b401773aac5fea9b47b4
>>>>>>> 235005530682cace0918232ee6195bc47f4ff930
@Configuration
public class PasswordEncoderConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
<<<<<<< HEAD
	    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
}
=======
<<<<<<< HEAD
	    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

=======
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
>>>>>>> f8bb319747be262fca91b401773aac5fea9b47b4
}
>>>>>>> 235005530682cace0918232ee6195bc47f4ff930
