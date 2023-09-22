package com.notebox.controller;

import com.notebox.model.Note;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/api/note")
public interface NoteControllerApi {
    @PostMapping("/create")
    ResponseEntity<Note> createNote(@RequestParam String title,
                                    @RequestParam String content);
    @PutMapping("/update")
    ResponseEntity<Note> updateNote(@RequestParam Long id,
                                    @RequestParam String title,
                                    @RequestParam String content);
    @DeleteMapping("/delete")
    ResponseEntity<Long> deleteNote(@RequestParam Long id);

    @GetMapping("/get/all")
    ResponseEntity<List<Note>> getAllNotes();

    @GetMapping("/get/by/title")
    ResponseEntity<List<Note>> getAllNotesByTitle(@RequestParam String title);
}
