package br.com.bancodojorge.apirest.infrastructure.services.impl;

import br.com.bancodojorge.apirest.domain.model.Usuario;
import br.com.bancodojorge.apirest.infrastructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JWTUserDetailsService implements UserDetailsService {

    @Autowired
    private final UsuarioRepository userRepository;

    public JWTUserDetailsService(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Usuario usuario = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username)));
        return new User(usuario.getUsername(), usuario.getPassword(), new ArrayList<>());
    }

}