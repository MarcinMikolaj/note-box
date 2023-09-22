package com.notebox.service;

import com.notebox.model.Note;

import java.util.List;

public interface NoteService {
    Note createNote(String title, String content);
    Note updateNote(Long id, String title, String content);
    Long deleteNote(Long id);
    List<Note> getAllNotes();
    List<Note> getAllNotesByTitle(String title);
}
