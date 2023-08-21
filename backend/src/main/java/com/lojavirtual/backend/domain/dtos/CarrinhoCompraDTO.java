package com.lojavirtual.backend.domain.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lojavirtual.backend.domain.models.CarrinhoCompra;
import com.lojavirtual.backend.domain.models.CarrinhoCompraItem;
import com.lojavirtual.backend.domain.models.Endereco;

public class CarrinhoCompraDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private Date dataCompra;
  private Endereco endereco;
  private List<CarrinhoCompraItem> carrinhoCompraItems = new ArrayList<>();

  public CarrinhoCompraDTO() {
  }

  public CarrinhoCompraDTO(Integer id, Date dataCompra, Endereco endereco, List<CarrinhoCompraItem> carrinhoCompraItems) {
    this.id = id;
    this.dataCompra = dataCompra;
    this.endereco = endereco;
    this.carrinhoCompraItems = carrinhoCompraItems;
  }

  public CarrinhoCompraDTO(CarrinhoCompra obj) {
    this.id = obj.getId();
    this.dataCompra = obj.getDataCompra();
    this.endereco = obj.getEndereco();
    this.carrinhoCompraItems = obj.getCarrinhoCompraItems();
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
    CarrinhoCompraDTO other = (CarrinhoCompraDTO) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
