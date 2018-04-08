package com.example.easynotes.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "notes")
@EntityListeners(AuditingEntityListener.class)
public class Note implements Serializable {


  private Long id;
  private String title;
  private String content;
  private LocalDate date = LocalDate.now();
  private List<Product> products;

  public Note() {
  }

  public Note(Long id, String title, String content, LocalDate date,
      List<Product> products) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.date = date;
    this.products = products;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "note_id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  @OneToMany(mappedBy = "note", cascade = CascadeType.ALL)
  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Note note = (Note) o;

    if (id != null ? !id.equals(note.id) : note.id != null) {
      return false;
    }
    if (title != null ? !title.equals(note.title) : note.title != null) {
      return false;
    }
    if (content != null ? !content.equals(note.content) : note.content != null) {
      return false;
    }
    if (date != null ? !date.equals(note.date) : note.date != null) {
      return false;
    }
    return products != null ? products.equals(note.products) : note.products == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (content != null ? content.hashCode() : 0);
    result = 31 * result + (date != null ? date.hashCode() : 0);
    result = 31 * result + (products != null ? products.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Note{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", content='" + content + '\'' +
        ", date=" + date +
        ", products=" + products +
        '}';
  }
}
