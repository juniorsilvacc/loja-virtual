package com.lojavirtual.backend.domain.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lojavirtual.backend.domain.dtos.UsuarioDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nome;

  @CPF
	@Column(unique = true)
  private String cpf;

  @Email
  @Column(unique = true) 
  private String email;
  
  private String senha;

  private String codigoRecuperacaoSenha;

  @Temporal(TemporalType.TIMESTAMP)
  private Date dataValidadeSenha;

  @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_usuario_permissao", joinColumns = {@JoinColumn (name = "usuario_id")},
		inverseJoinColumns =  {@JoinColumn (name = "permissao_id")}
	)
	private List<Permissao> permissoes;

  @JsonIgnore
  @OneToOne(mappedBy = "usuario")
  private CarrinhoCompra carrinhoCompra;

  public Usuario() {
  }

  public Usuario(Integer id, String nome, String cpf, String email, String senha) {
    this.id = id;
    this.nome = nome;
    this.cpf = cpf;
    this.email = email;
    this.senha = senha;
  }

  public Usuario(UsuarioDTO obj) {
    this.id = obj.getId();
    this.nome = obj.getNome();
    this.cpf = obj.getCpf();
    this.email = obj.getEmail();
    this.senha = obj.getSenha();
  }

  public List<String> getRoles() {
    List<String> roles = new ArrayList<>();
		for (Permissao permissao : permissoes) {
			roles.add(permissao.getNome());
		}
		
		return roles ;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.permissoes;
  }

  @Override
  public String getPassword() {
    return senha;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
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

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getCodigoRecuperacaoSenha() {
    return codigoRecuperacaoSenha;
  }

  public void setCodigoRecuperacaoSenha(String codigoRecuperacaoSenha) {
    this.codigoRecuperacaoSenha = codigoRecuperacaoSenha;
  }

  public Date getDataValidadeSenha() {
    return dataValidadeSenha;
  }

  public void setDataValidadeSenha(Date dataValidadeSenha) {
    this.dataValidadeSenha = dataValidadeSenha;
  }

  public List<Permissao> getPermissoes() {
    if (permissoes == null) {
			permissoes = new ArrayList<>();
		}
		return permissoes;
  }

  public void setPermissoes(List<Permissao> permissoes) {
    this.permissoes = permissoes;
  }
  
  public CarrinhoCompra getCarrinhoCompra() {
    return carrinhoCompra;
  }

  public void setCarrinhoCompra(CarrinhoCompra carrinhoCompra) {
    this.carrinhoCompra = carrinhoCompra;
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
    Usuario other = (Usuario) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
  
}
