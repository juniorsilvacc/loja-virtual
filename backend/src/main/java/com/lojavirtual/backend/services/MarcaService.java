package com.lojavirtual.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojavirtual.backend.domain.dtos.MarcaDTO;
import com.lojavirtual.backend.domain.models.Marca;
import com.lojavirtual.backend.repositories.MarcaRepository;
import com.lojavirtual.backend.services.exceptions.DataIntegrityViolationException;
import com.lojavirtual.backend.services.exceptions.ObjectNotFoundException;

@Service
public class MarcaService {

  @Autowired
  private MarcaRepository repository;

  public MarcaDTO create(Marca marca) {
    Optional<Marca> nomeMarca = repository.findByNome(marca.getNome());

    if(nomeMarca.isPresent()) {
      throw new DataIntegrityViolationException("O nome desse marca já existe");
    }

    Marca salvarMarca = repository.save(marca);
    
    MarcaDTO dto = new MarcaDTO(salvarMarca);

    return dto;
  }

  public void remove(Integer id) {
    Optional<Marca> idMarca = repository.findById(id);

    if(!idMarca.isPresent()) {
      throw new ObjectNotFoundException(String.format("Marca com id: %d não encontrada", id));
    }

    repository.deleteById(id);
  }

  public List<MarcaDTO> findAll() {
    List<Marca> todasMarcas = repository.findAll();
    List<MarcaDTO> dto = todasMarcas.stream().map(MarcaDTO::new).collect(Collectors.toList());
    return dto;
  }

  public MarcaDTO findById(Integer id) {
    Marca marca = repository.findById(id)
      .orElseThrow(() -> new ObjectNotFoundException(String.format("Marca com id: %d não encontrada", id)));

    MarcaDTO dto = new MarcaDTO(marca);

    return dto;
  }

  public MarcaDTO update(Marca marca, Integer id) {
    Optional<Marca> oldMarca = repository.findById(id);

    if(!oldMarca.isPresent()) {
      System.out.println("Marca não encontrada");
    }

    BeanUtils.copyProperties(marca, oldMarca.get(), "id");

    Marca salvarMarca = repository.save(oldMarca.get());
    
    MarcaDTO dto = new MarcaDTO(salvarMarca);
 
    return dto;
  }
  
}
