package com.lojavirtual.backend.domain.models;

import java.io.Serializable;
import java.util.Date;

import com.lojavirtual.backend.domain.dtos.CidadeDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_cidade")
public class Cidade implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  private String nome;

  @Temporal(TemporalType.TIMESTAMP)
  private Date dataCriacao;

  @Temporal(TemporalType.TIMESTAMP)
  private Date dataAtualizacao;

  public Cidade() {
  }

  public Cidade(Integer id, String nome, String sigla, Date dataCriacao, Date dataAtualizacao) {
    this.id = id;
    this.nome = nome;
    this.dataCriacao = dataCriacao;
    this.dataAtualizacao = dataAtualizacao;
  }

  public Cidade(CidadeDTO obj) {
    this.id = obj.getId();
    this.nome = obj.getNome();
    this.dataCriacao = obj.getDataCriacao();
    this.dataAtualizacao = obj.getDataAtualizacao();
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

  public Date getDataCriacao() {
    return dataCriacao;
  }

  public void setDataCriacao(Date dataCriacao) {
    this.dataCriacao = dataCriacao;
  }

  public Date getDataAtualizacao() {
    return dataAtualizacao;
  }

  public void setDataAtualizacao(Date dataAtualizacao) {
    this.dataAtualizacao = dataAtualizacao;
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
    Cidade other = (Cidade) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
 
}
