package com.notebox.controller;

import com.notebox.infrastructure.validation.NoteContent;
import com.notebox.infrastructure.validation.NoteTitle;
import com.notebox.model.Note;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RequestMapping(path="/v1/api/note", produces = MediaType.APPLICATION_JSON_VALUE)
public interface NoteControllerApi {
    @PostMapping("/create")
    ResponseEntity<Note> createNote(@RequestParam @NoteTitle String title,
                                    @RequestParam @NoteContent String content);
    @PutMapping("/update")
    ResponseEntity<Note> updateNote(@RequestParam Long id,
                                    @RequestParam @NoteTitle String title,
                                    @RequestParam @NoteContent String content);
    @DeleteMapping("/delete")
    ResponseEntity<Long> deleteNote(@RequestParam Long id);

    @GetMapping("/get/all")
    ResponseEntity<List<Note>> getAllNotes();

    @GetMapping("/get/by/title")
    ResponseEntity<List<Note>> getAllNotesByTitle(@RequestParam String title);
}
