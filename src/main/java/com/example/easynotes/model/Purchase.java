package com.example.easynotes.model;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class Purchase {

  @ApiModelProperty(required = true, example = "1")
  private int idProduct;
  @ApiModelProperty(required = true, example = "A")
  private String name;
  @ApiModelProperty(required = true, example = "3")
  private Integer quantity;
  @ApiModelProperty(required = true, example = "20")
  private BigDecimal price;

  public Purchase() {
  }

  public Purchase(int idProduct, String name, Integer quantity, BigDecimal price) {
    this.idProduct = idProduct;
    this.name = name;
    this.quantity = quantity;
    this.price = price;
  }

  public int getIdProduct() {
    return idProduct;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public void setIdProduct(int idProduct) {
    this.idProduct = idProduct;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Purchase purchase = (Purchase) o;

    if (idProduct != purchase.idProduct) {
      return false;
    }
    if (name != null ? !name.equals(purchase.name) : purchase.name != null) {
      return false;
    }
    if (quantity != null ? !quantity.equals(purchase.quantity) : purchase.quantity != null) {
      return false;
    }
    return price != null ? price.equals(purchase.price) : purchase.price == null;
  }

  @Override
  public int hashCode() {
    int result = idProduct;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
    result = 31 * result + (price != null ? price.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Purchase{" +
        "idProduct=" + idProduct +
        ", name='" + name + '\'' +
        ", quantity=" + quantity +
        ", price=" + price +
        '}';
  }
}
