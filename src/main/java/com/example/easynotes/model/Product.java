package com.example.easynotes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@EntityListeners(AuditingEntityListener.class)
public class Product implements Serializable {

  @JsonIgnore
  private int idProduct;
  private String name;
  private Integer quantity;
  private BigDecimal price;
  private BigDecimal sums;
  @JsonIgnore
  private Note note;

  public Product() {
  }

  public Product(String name, Integer quantity, BigDecimal price,
      BigDecimal sums) {
    this.name = name;
    this.quantity = quantity;
    this.price = price;
    this.sums = sums;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int getIdProduct() {
    return idProduct;
  }

  public void setIdProduct(int idProduct) {
    this.idProduct = idProduct;
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

  public BigDecimal getSums() {
    return sums;
  }

  public void setSums(BigDecimal sums) {
    this.sums = sums;
  }

  @ManyToOne(cascade = {CascadeType.DETACH,
      CascadeType.MERGE, CascadeType.PERSIST,
      CascadeType.REFRESH})
  @JoinColumn(name = "note_id", referencedColumnName = "note_id")
  public Note getNote() {
    return note;
  }

  public void setNote(Note note) {
    this.note = note;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Product product = (Product) o;

    if (idProduct != product.idProduct) {
      return false;
    }
    if (name != null ? !name.equals(product.name) : product.name != null) {
      return false;
    }
    if (quantity != null ? !quantity.equals(product.quantity) : product.quantity != null) {
      return false;
    }
    if (price != null ? !price.equals(product.price) : product.price != null) {
      return false;
    }
    return sums != null ? sums.equals(product.sums) : product.sums == null;
  }

  @Override
  public int hashCode() {
    int result = idProduct;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
    result = 31 * result + (price != null ? price.hashCode() : 0);
    result = 31 * result + (sums != null ? sums.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Product{" +
        "idProduct=" + idProduct +
        ", name='" + name + '\'' +
        ", quantity=" + quantity +
        ", price=" + price +
        ", sums=" + sums +
        '}';
  }
}
