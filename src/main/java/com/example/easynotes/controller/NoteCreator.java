package com.example.easynotes.controller;

import com.example.easynotes.database.Database;
import com.example.easynotes.model.Note;
import com.example.easynotes.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
class NoteCreator {

  private final Database database;

  NoteCreator(Database database) {
    this.database = database;
  }

  void saveNote(Note note) {
    database.saveNote(note);
  }

  List<Note> listNote() {
    return database.listNote();
  }

  Note createNote(String title, String content, List<Product> products) {
    return database.createNote(title, content, products);
  }

  Product createProduct(String name, Integer quantity, BigDecimal price) {
    Product product = database.createProduct(name, quantity, price);
    return product;
  }

  void addProduct(Product product) {
    database.addProduct(product);
  }

  List<Product> listProduct() {
    return database.listProduct();
  }
}
