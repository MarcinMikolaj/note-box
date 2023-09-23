package com.notebox.service;

import com.notebox.dto.NoteDto;
import com.notebox.model.Note;

import java.util.List;

public interface NoteService {
    Note createNote(NoteDto noteDto);
    Note updateNote(NoteDto noteDto);
    Long deleteNote(Long id);
    List<Note> getAllNotes();
    List<Note> getAllNotesByTitle(String title);
}
