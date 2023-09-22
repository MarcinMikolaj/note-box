package com.notebox.service.impl;

import com.notebox.model.Note;
import com.notebox.service.NoteService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Override
    public Note createNote(String title, String content) {
        return buildNote(title, content);
    }

    @Override
    public Note updateNote(Long id, String title, String content) {
        return null;
    }

    @Override
    public Long deleteNote(Long id) {
        return null;
    }

    @Override
    public List<Note> getAllNotes() {
        return null;
    }

    @Override
    public List<Note> getAllNotesByTitle(String title) {
        return null;
    }

    private Note buildNote(String title, String content){
        return Note.builder()
                .title(title)
                .content(content)
                .date(LocalDateTime.now())
                .build();
    }
}
