package com.lojavirtual.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lojavirtual.backend.domain.dtos.UsuarioDTO;
import com.lojavirtual.backend.domain.models.Permissao;
import com.lojavirtual.backend.domain.models.Usuario;
import com.lojavirtual.backend.repositories.PermissaoRepository;
import com.lojavirtual.backend.repositories.UsuarioRepository;
import com.lojavirtual.backend.services.exceptions.DataIntegrityViolationException;
import com.lojavirtual.backend.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

  @Autowired
  private UsuarioRepository repository;

  @Autowired
  private PermissaoRepository permissao;

  @Autowired
  private EmailService emailService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public UsuarioDTO create(Usuario usuario) {
    Optional<Usuario> emailUsuario = repository.findByEmail(usuario.getEmail());
    Optional<Usuario> cpfUsuario = repository.findByCpf(usuario.getCpf());

    Permissao role = permissao.findByNome("ROLE_GERENT");

    if(role == null) {
      throw new DataIntegrityViolationException("Essa permissão ainda não está cadastrada no sistema");
    }

    if(emailUsuario.isPresent()) {
      throw new DataIntegrityViolationException("Esse E-mail e/ou CPF já existe");
    }

    if(cpfUsuario.isPresent()) {
      throw new DataIntegrityViolationException("Esse E-mail e/ou CPF já existe");
    }

    usuario.getPermissoes().add(role);
    usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
    Usuario salvarUsuario = repository.save(usuario);

    emailService.enviarEmail(
      usuario.getEmail(), 
      "Bem vindo! Você agora pode fazer o gerenciamento da loja virtual.", 
      "Olá, " + usuario.getNome() + ". Você é um dos novos funcionários da loja!");
    
    UsuarioDTO dto = new UsuarioDTO(salvarUsuario);

    return dto;
  }

  public void remove(Integer id) {
    Optional<Usuario> idUsuario = repository.findById(id);

    if(!idUsuario.isPresent()) {
      throw new ObjectNotFoundException(String.format("Usuario com id: %d não encontrado", id));
    }

    repository.deleteById(id);
  }

  public List<UsuarioDTO> findAll() {
    List<Usuario> todasUsuarios = repository.findAll();
    List<UsuarioDTO> dto = todasUsuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    return dto;
  }

  public UsuarioDTO findById(Integer id) {
    Usuario usuario = repository.findById(id)
      .orElseThrow(() -> new ObjectNotFoundException(String.format("Usuario com id: %d não encontrado", id)));

    UsuarioDTO dto = new UsuarioDTO(usuario);

    return dto;
  }

  public UsuarioDTO update(Usuario usuario, Integer id) {
    Optional<Usuario> oldUsuario = repository.findById(id);

    if(!oldUsuario.isPresent()) {
      throw new ObjectNotFoundException(String.format("Usuario com id: %d não encontrado", id));
    }

    BeanUtils.copyProperties(usuario, oldUsuario.get(), "id");

    Usuario salvarUsuario = repository.save(oldUsuario.get());
    
    UsuarioDTO dto = new UsuarioDTO(salvarUsuario);
 
    return dto;
  }
  
}
