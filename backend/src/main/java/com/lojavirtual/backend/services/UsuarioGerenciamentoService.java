package com.lojavirtual.backend.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojavirtual.backend.domain.models.Usuario;
import com.lojavirtual.backend.repositories.UsuarioRepository;
import com.lojavirtual.backend.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioGerenciamentoService {

  @Autowired
  private UsuarioRepository repository;

  @Autowired
  private EmailService emailService;

  public String solicitarSenha(String email) {
    Usuario usuario = repository.findByEmail(email).get();

    if(usuario == null) {
      throw new ObjectNotFoundException("E-mail não encontrado");
    }

    usuario.setCodigoRecuperacaoSenha(getCodigoRecuperacaoSenha(usuario.getId()));
    usuario.setDataValidadeSenha(new Date());

    repository.save(usuario);

    emailService.enviarEmail(
      usuario.getEmail(), 
      "Código de verificação de senha", 
      "Olá, o seu código para recuperação de senha é: " + usuario.getCodigoRecuperacaoSenha());
    
    return "Código enviado com sucesso.";
  }

  public String alterarSenha(Usuario usuario) {
    Usuario usuarioBancoDados = repository.findByEmailAndCodigoRecuperacaoSenha(usuario.getEmail(), usuario.getCodigoRecuperacaoSenha());

    if(usuarioBancoDados == null) {
      throw new ObjectNotFoundException("E-mail e/ou código não encontrado");
    }
    
    Date diferenca = new Date(new Date().getTime() - usuarioBancoDados.getDataValidadeSenha().getTime());

    if(diferenca.getTime() / 1000 < 900) {
      usuarioBancoDados.setSenha(usuario.getSenha());
      usuarioBancoDados.setCodigoRecuperacaoSenha(null);

      repository.save(usuarioBancoDados);

      return "Senha alterada com sucesso!";
    } else {
      return "Tempo expirado, solicite um novo código.";
    }
  }

  private String getCodigoRecuperacaoSenha(Integer id) {
    DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssmm");
    return format.format(new Date()) + id;
  }

}
