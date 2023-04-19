package com.lojavirtual.backend.domain.dtos;

import java.util.Date;

import com.lojavirtual.backend.domain.models.Cidade;

public class CidadeDTO {

  private Integer id;
  private String nome;
  private Date dataCriacao;
  private Date dataAtualizacao;

  public CidadeDTO() {
  }

  public CidadeDTO(Integer id, String nome, String sigla, Date dataCriacao, Date dataAtualizacao) {
    this.id = id;
    this.nome = nome;
    this.dataCriacao = dataCriacao;
    this.dataAtualizacao = dataAtualizacao;
  }

  public CidadeDTO(Cidade obj) {
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
    CidadeDTO other = (CidadeDTO) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
