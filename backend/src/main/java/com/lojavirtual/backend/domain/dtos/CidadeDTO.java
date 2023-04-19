package com.lojavirtual.backend.domain.dtos;

import java.io.Serializable;

import com.lojavirtual.backend.domain.models.Cidade;

public class CidadeDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

  private Integer id;
  private String nome;

  private Integer estado;

  public CidadeDTO() {
  }

  public CidadeDTO(Integer id, String nome, String sigla, Integer estado) {
    this.id = id;
    this.nome = nome;
    this.estado = estado;
  }

  public CidadeDTO(Cidade obj) {
    this.id = obj.getId();
    this.nome = obj.getNome();
    this.estado = obj.getEstado().getId();
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

  public Integer getEstado() {
    return estado;
  }

  public void setEstado(Integer estado) {
    this.estado = estado;
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
    CidadeDTO other = (CidadeDTO) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
