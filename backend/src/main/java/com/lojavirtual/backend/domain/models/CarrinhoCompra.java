package com.lojavirtual.backend.domain.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_carrinho_compra")
public class CarrinhoCompra implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @JsonFormat(pattern="dd/MM/yyyy HH:mm")
  private Date dataCompra;

  @OneToOne
  @JoinColumn(name = "usuario_id")
  private Usuario usuario;

  @OneToOne
  @JoinColumn(name = "endereco_id")
  private Endereco endereco;

  @OneToMany(mappedBy = "carrinhoCompra")
  private List<CarrinhoCompraItem> carrinhoCompraItems = new ArrayList<>();
 
  public CarrinhoCompra() {
  }

  public CarrinhoCompra(Integer id, Date dataCompra, Usuario usuario, Endereco endereco) {
    this.id = id;
    this.dataCompra = dataCompra;
    this.usuario = usuario;
    this.endereco = endereco;
  }

  public Double getTotal() {
    double soma = 0.0;
    for(CarrinhoCompraItem x : carrinhoCompraItems) {
      soma = soma + x.getSubTotal();
    }
    return soma;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getDataCompra() {
    return dataCompra;
  }

  public void setDataCompra(Date dataCompra) {
    this.dataCompra = dataCompra;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public List<CarrinhoCompraItem> getCarrinhoCompraItems() {
    return carrinhoCompraItems;
  }

  public void setCarrinhoCompraItems(List<CarrinhoCompraItem> carrinhoCompraItems) {
    this.carrinhoCompraItems = carrinhoCompraItems;
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
    CarrinhoCompra other = (CarrinhoCompra) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
