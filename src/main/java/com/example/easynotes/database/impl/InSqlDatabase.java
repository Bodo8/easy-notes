package com.example.easynotes.database.impl;

import com.example.easynotes.database.Database;
import com.example.easynotes.model.Note;
import com.example.easynotes.model.NoteBuilder;
import com.example.easynotes.model.Product;
import com.example.easynotes.model.ProductBuilder;
import com.example.easynotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
class InSqlDatabase implements Database {

  private static AtomicInteger atomicInteger = new AtomicInteger(1);
  private final List<Product> productList = new ArrayList<>();

  @Autowired
  NoteRepository noteRepository;

  @Override
  public void saveNote(Note note) {
    noteRepository.save(note);
  }

  @Override
  public List<Note> listNote() {
    return noteRepository.findAll();
  }

  @Override
  public Note createNote(String title, String content, List<Product> products) {
    return NoteBuilder.builder()
        .buildWithoutId(title, content, products);
  }

  @Override
  public Product createProduct(String name, Integer quantity, BigDecimal price) {
    Product product = ProductBuilder.builder()
        .buildWithOutId(name, quantity, price, new BigDecimal(100));
    return product;
  }

  @Override
  public void addProduct(Product product) {
    productList.add(product);
  }

  @Override
  public List<Product> listProduct() {
    return productList;
  }

  private Integer getNextId() {
    return atomicInteger.getAndIncrement();
  }
}
