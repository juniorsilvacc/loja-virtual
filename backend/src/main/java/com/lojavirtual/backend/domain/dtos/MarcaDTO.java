package com.lojavirtual.backend.domain.dtos;

import java.io.Serializable;

import com.lojavirtual.backend.domain.models.Marca;

public class MarcaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

  private Integer id;
  private String nome;
  
  public MarcaDTO() {
  }

  public MarcaDTO(Integer id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public MarcaDTO(Marca obj) {
    this.id = obj.getId();
    this.nome = obj.getNome();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    MarcaDTO other = (MarcaDTO) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
  
}
