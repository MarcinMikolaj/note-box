package com.notebox.controller;

import com.notebox.dto.NoteDto;
import com.notebox.model.Note;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path="/v1/api/note", produces = MediaType.APPLICATION_JSON_VALUE)
public interface NoteControllerApi {
    @PostMapping("/create")
    ResponseEntity<Note> createNote(@Valid @RequestBody NoteDto noteDto);

    @PutMapping("/update")
    ResponseEntity<Note> updateNote(@Valid @RequestBody NoteDto noteDto);

    @DeleteMapping("/delete")
    ResponseEntity<Long> deleteNote(@RequestParam Long id);

    @GetMapping("/get/all")
    ResponseEntity<List<Note>> getAllNotes();

    @GetMapping("/get/by/title")
    ResponseEntity<List<Note>> getAllNotesByTitle(@RequestParam String title);
}
