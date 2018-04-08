package com.example.easynotes.controller;

import com.example.easynotes.model.Note;
import com.example.easynotes.model.Product;
import com.example.easynotes.model.Purchase;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
class NoteService {

  @Resource
  private final NoteCreator noteCreator;

  NoteService(NoteCreator noteCreator) {
    this.noteCreator = noteCreator;
  }

  long postNote(Purchase purchase) {
    String name = purchase.getName();
    Integer quantity = purchase.getQuantity();
    BigDecimal price = purchase.getPrice();
    Product product = noteCreator.createProduct(name, quantity, price);
    noteCreator.addProduct(product);
    List<Product> products = noteCreator.listProduct();
    Note note = noteCreator.createNote("title1", "note test", products);
    noteCreator.saveNote(note);
    return purchase.getIdProduct();
  }

  List<Note> getAllNotes() {
    return noteCreator.listNote();
  }
}
