package com.example.easynotes.controller;

import com.example.easynotes.model.Note;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

  private final NoteService service;

  public NoteController(NoteService service) {
    this.service = service;
  }

  @ApiOperation(value = "Get list of all notes",
      response = Note.class, responseContainer = "List")
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Note> getAllNotes() {
    return service.getAllNotes();
  }

  @ApiOperation(value = "Post another note",
      response = Integer.class)
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Long postNote(
      @ApiParam(value = "note data")
      @RequestBody Note note) throws IOException {
    return service.postNote(note);
  }
}
