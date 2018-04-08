package com.example.easynotes.model;

import java.time.LocalDate;
import java.util.List;

public class NoteBuilder {

  private Long id;
  private String title;
  private String content;
  private LocalDate date;
  private List<Product> products;

  public static NoteBuilder builder() {
    return new NoteBuilder();
  }

  public NoteBuilder withId(Long id) {
    this.id = id;
    return this;
  }

  public NoteBuilder withTitle(String title) {
    this.title = title;
    return this;
  }

  public NoteBuilder withContent(String content) {
    this.content = content;
    return this;
  }

  public NoteBuilder withDate(LocalDate date) {
    this.date = date;
    return this;
  }

  public NoteBuilder withProducts(List<Product> products) {
    this.products = products;
    return this;
  }

  public Note build() {
    return new Note(id, title, content, date, products);
  }

  public Note buildWithoutId(String title, String content, List<Product> products) {
    return NoteBuilder.builder()
        .withTitle(title)
        .withContent(content)
        .withDate(LocalDate.now())
        .withProducts(products)
        .build();

  }
}
