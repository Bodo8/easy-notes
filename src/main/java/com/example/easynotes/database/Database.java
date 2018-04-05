package com.example.easynotes.database;

import com.example.easynotes.model.Note;

import java.util.List;

public interface Database {

  void saveNote(Note note);

  List<Note> listNote();

  Note createNote(String title, String content);
}
