package com.lojavirtual.backend.domain.dtos;

import java.io.Serializable;

import com.lojavirtual.backend.domain.models.Cidade;
import com.lojavirtual.backend.domain.models.Endereco;
import com.lojavirtual.backend.domain.models.Usuario;

public class EnderecoDTO implements Serializable {
  
  private static final long serialVersionUID = 1L;

  private Integer id;
  
	private String nome;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;

	private Cidade cidade;
  private Usuario usuario;

  public EnderecoDTO() {
  }

  public EnderecoDTO(Integer id, String nome, String logradouro, String numero, String complemento, String bairro, Cidade cidade, Usuario usuario) {
    this.id = id;
    this.nome = nome;
    this.logradouro = logradouro;
    this.numero = numero;
    this.complemento = complemento;
    this.bairro = bairro;
    this.cidade = cidade;
    this.usuario = usuario;
  }

  public EnderecoDTO(Endereco obj) {
    this.id = obj.getId();
    this.nome = obj.getNome();
    this.logradouro = obj.getLogradouro();
    this.numero = obj.getNumero();
    this.complemento = obj.getComplemento();
    this.bairro = obj.getBairro();
    this.cidade = obj.getCidade();
    this.usuario = obj.getUsuario();
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

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public Cidade getCidade() {
    return cidade;
  }

  public void setCidade(Cidade cidade) {
    this.cidade = cidade;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
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
    EnderecoDTO other = (EnderecoDTO) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
}
