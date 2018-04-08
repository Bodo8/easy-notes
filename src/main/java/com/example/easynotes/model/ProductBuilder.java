package com.example.easynotes.model;

import java.math.BigDecimal;

public class ProductBuilder {

  private int idProduct;
  private String name;
  private Integer quantity;
  private BigDecimal price;
  private BigDecimal sums;

  public static ProductBuilder builder() {
    return new ProductBuilder();
  }

  public ProductBuilder withIdProduct(int idProduct) {
    this.idProduct = idProduct;
    return this;
  }

  public ProductBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public ProductBuilder withQuantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  public ProductBuilder withPrice(BigDecimal price) {
    this.price = price;
    return this;
  }

  public ProductBuilder withSums(BigDecimal sums) {
    this.sums = sums;
    return this;
  }

  public Product buildWithOutId(String name,
      Integer quantity, BigDecimal price, BigDecimal sums) {
    return new Product(name, quantity, price, sums);
  }
}
