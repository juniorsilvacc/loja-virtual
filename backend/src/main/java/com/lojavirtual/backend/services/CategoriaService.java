package com.lojavirtual.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojavirtual.backend.domain.dtos.CategoriaDTO;
import com.lojavirtual.backend.domain.models.Categoria;
import com.lojavirtual.backend.repositories.CategoriaRepository;
import com.lojavirtual.backend.services.exceptions.DataIntegrityViolationException;
import com.lojavirtual.backend.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

  @Autowired
  private CategoriaRepository repository;

  public CategoriaDTO create(Categoria categoria) {
    Optional<Categoria> nomeCategoria = repository.findByNome(categoria.getNome());

    if(nomeCategoria.isPresent()) {
      throw new DataIntegrityViolationException("O nome desse categoria já existe");
    }

    Categoria salvarCategoria = repository.save(categoria);
    
    CategoriaDTO dto = new CategoriaDTO(salvarCategoria);

    return dto;
  }

  public void remove(Integer id) {
    Optional<Categoria> idCategoria = repository.findById(id);

    if(!idCategoria.isPresent()) {
      throw new ObjectNotFoundException(String.format("Categoria com id: %d não encontrada", id));
    }

    repository.deleteById(id);
  }

  public List<CategoriaDTO> findAll() {
    List<Categoria> todasCategorias = repository.findAll();
    List<CategoriaDTO> dto = todasCategorias.stream().map(CategoriaDTO::new).collect(Collectors.toList());
    return dto;
  }

  public CategoriaDTO findById(Integer id) {
    Categoria categoria = repository.findById(id)
      .orElseThrow(() -> new ObjectNotFoundException(String.format("Categoria com id: %d não encontrada", id)));

    CategoriaDTO dto = new CategoriaDTO(categoria);

    return dto;
  }

  public CategoriaDTO update(Categoria categoria, Integer id) {
    Optional<Categoria> oldCategoria = repository.findById(id);

    if(!oldCategoria.isPresent()) {
      throw new ObjectNotFoundException(String.format("Categoria com id: %d não encontrada", id));
    }

    BeanUtils.copyProperties(categoria, oldCategoria.get(), "id");

    Categoria salvarCategoria = repository.save(oldCategoria.get());
    
    CategoriaDTO dto = new CategoriaDTO(salvarCategoria);
 
    return dto;
  }
  
}
