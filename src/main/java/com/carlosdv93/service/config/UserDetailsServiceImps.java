package com.carlosdv93.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.carlosdv93.model.Usuario;
import com.carlosdv93.repositories.UsuarioRepository;

@Component
public class UserDetailsServiceImps implements UserDetailsService {

	@Autowired
	private UsuarioRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repo.findByUsername(username);

		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		} else {
			return usuario;
		}
	}

}
