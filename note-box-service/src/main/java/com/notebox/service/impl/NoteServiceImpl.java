package com.notebox.service.impl;

import com.notebox.dto.NoteDto;
import com.notebox.model.Note;
import com.notebox.repository.NoteRepository;
import com.notebox.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    @Override
    public Note createNote(NoteDto noteDto) {
        return noteRepository.save(Note.builder()
                .title(noteDto.title())
                .content(noteDto.content())
                .date(LocalDateTime.now())
                .build());
    }

    @Override
    public Note updateNote(NoteDto noteDto) {
        return noteRepository.save(Note.builder()
                .id(noteDto.id())
                .title(noteDto.title())
                .content(noteDto.content())
                .date(LocalDateTime.now())
                .build());
    }

    @Override
    public Long deleteNote(Long id) {
        noteRepository.deleteById(id);
        return id;
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public List<Note> getAllNotesByTitle(String title) {
        return noteRepository.findByTitleContaining(title);
    }

}
