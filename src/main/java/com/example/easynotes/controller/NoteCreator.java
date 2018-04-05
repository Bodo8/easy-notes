package com.example.easynotes.controller;

import com.example.easynotes.database.Database;
import com.example.easynotes.model.Note;
import org.springframework.stereotype.Service;

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

  Note createNote(String title, String content) {
    return database.createNote(title, content);
  }
}
