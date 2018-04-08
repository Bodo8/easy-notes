package com.example.easynotes.database;

import com.example.easynotes.model.Note;
import com.example.easynotes.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface Database {

  void saveNote(Note note);

  List<Note> listNote();

  Note createNote(String title, String content, List<Product> products);

  Product createProduct(String name, Integer quantity, BigDecimal price);

  void addProduct(Product product);

  List<Product> listProduct();
}
