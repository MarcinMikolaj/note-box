package com.notebox.controller.impl;

import com.notebox.controller.NoteControllerApi;
import com.notebox.model.Note;
import com.notebox.service.NoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class NoteController implements NoteControllerApi {
    private final NoteService noteService;

    @Override
    public ResponseEntity<Note> createNote(String title, String content) {
        log.info("Received request to create note title: {} content: {}", title, content);
        return ResponseEntity.status(HttpStatus.CREATED).body(noteService.createNote(title, content));
    }

    @Override
    public ResponseEntity<Note> updateNote(Long id, String title, String content) {
        log.info("Received request to update note id: {} title: {} content: {}", id, title, content);
        return ResponseEntity.status(HttpStatus.OK).body(noteService.updateNote(id, title, content));
    }

    @Override
    public ResponseEntity<Long> deleteNote(Long id) {
        log.info("Received request to remove note id: {}", id);
        return ResponseEntity.status(HttpStatus.OK).body(noteService.deleteNote(id));
    }

    @Override
    public ResponseEntity<List<Note>> getAllNotes() {
        log.info("Received request to get all notes");
        return ResponseEntity.status(HttpStatus.OK).body(noteService.getAllNotes());
    }

    @Override
    public ResponseEntity<List<Note>> getAllNotesByTitle(String title) {
        log.info("Received request to get notes by title title: {}", title);
        return ResponseEntity.status(HttpStatus.OK).body(noteService.getAllNotesByTitle(title));
    }
}
