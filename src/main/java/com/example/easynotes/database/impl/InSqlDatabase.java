package com.example.easynotes.database.impl;

import com.example.easynotes.database.Database;
import com.example.easynotes.model.Note;
import com.example.easynotes.model.NoteBuilder;
import com.example.easynotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class InSqlDatabase implements Database {

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
  public Note createNote(String title, String content) {
    return NoteBuilder.builder()
        .buildWithoutId(title, content);
  }

}
