package com.example.easynotes.model;

import java.util.Date;

public class NoteBuilder {

  private Long id;

  private String title;

  private String content;

  private Date createdAt;

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

  public NoteBuilder withDate(Date createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public Note build() {
    return new Note(id, title, content, new Date());
  }

  public Note buildWithoutId(String title, String content) {
    return NoteBuilder.builder()
        .withTitle(title)
        .withContent(content)
        .withDate(new Date())
        .build();

  }
}
