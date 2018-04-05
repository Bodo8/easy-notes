package com.example.easynotes.controller;

import com.example.easynotes.model.Note;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class NoteService {

  @Resource
  private final NoteCreator noteCreator;

  NoteService(NoteCreator noteCreator) {
    this.noteCreator = noteCreator;
  }

  long postNote(Note note) {
    // Note note = noteCreator.createNote(title, content);
    noteCreator.saveNote(note);
    return note.getId();
  }

  List<Note> getAllNotes() {
    return noteCreator.listNote();
  }
}
