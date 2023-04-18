package com.lojavirtual.backend.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojavirtual.backend.domain.dtos.EstadoDTO;
import com.lojavirtual.backend.domain.models.Estado;
import com.lojavirtual.backend.repositories.EstadoRepository;

@Service
public class EstadoService {

  @Autowired
  private EstadoRepository repository;

  public EstadoDTO create(EstadoDTO estado) {
    Optional<Estado> nomeEstado = repository.findByNome(estado.getNome());

    if(nomeEstado.isPresent()) {
      System.out.println("O cadastro desse estado já existe");
    }

    Estado novoEstado = new Estado(estado);
    novoEstado.setDataCriacao(new Date());
    
    Estado estadoSalvo = repository.save(novoEstado);
    
    EstadoDTO dto = new EstadoDTO(estadoSalvo);

    return dto;
  }

  public void remove(Integer id) {
    Optional<Estado> idEstado = repository.findById(id);

    if(idEstado.isEmpty()) {
      System.out.println("Estado não encontrado");
    }

    repository.deleteById(id);
  }

  public List<EstadoDTO> findAll() {
    List<Estado> todosEstados = repository.findAll();
    List<EstadoDTO> dto = todosEstados.stream().map(EstadoDTO::new).collect(Collectors.toList());
    return dto;
  }

  public EstadoDTO findById(Integer id) {
    Estado estado = repository.findById(id).get();

    if(estado == null) {
      System.out.println("Estado não encontrado");
    }

    EstadoDTO dto = new EstadoDTO(estado);

    return dto;
  }

  public EstadoDTO update(EstadoDTO estado, Integer id) {
    Optional<Estado> oldEstado = repository.findById(id);

    if(!oldEstado.isPresent()) {
      System.out.println("Estado não encontrado");
    }

    BeanUtils.copyProperties(estado, oldEstado.get(), "id");

    Estado salvarEstado = repository.save(oldEstado.get());
    
    EstadoDTO dto = new EstadoDTO(salvarEstado);

    return dto;
  }
  
}
