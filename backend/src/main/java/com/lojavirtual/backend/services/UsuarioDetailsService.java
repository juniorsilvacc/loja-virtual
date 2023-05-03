package com.lojavirtual.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lojavirtual.backend.domain.models.Usuario;
import com.lojavirtual.backend.repositories.UsuarioRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService {

  @Autowired
  private UsuarioRepository repository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Usuario usuario = repository.findByEmail(email).get();
    
    if(usuario == null) {
      throw new UsernameNotFoundException("Usuário não encontrado");
    }

    return usuario;
  }
  
}
