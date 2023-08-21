package com.lojavirtual.backend.domain.dtos;

import java.io.Serializable;

import com.lojavirtual.backend.domain.models.Estado;

public class EstadoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

  private Integer id;
  private String nome;
  private String sigla;

  public EstadoDTO() {
  }

  public EstadoDTO(Integer id, String nome, String sigla) {
    this.id = id;
    this.nome = nome;
    this.sigla = sigla;
  }

  public EstadoDTO(Estado obj) {
    this.id = obj.getId();
    this.nome = obj.getNome();
    this.sigla = obj.getSigla();
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

  public String getSigla() {
    return sigla;
  }

  public void setSigla(String sigla) {
    this.sigla = sigla;
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
    EstadoDTO other = (EstadoDTO) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
