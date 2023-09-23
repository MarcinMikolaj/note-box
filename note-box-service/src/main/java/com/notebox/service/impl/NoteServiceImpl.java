package com.notebox.service.impl;

import com.notebox.dto.NoteDto;
import com.notebox.model.Note;
import com.notebox.repository.NoteRepository;
import com.notebox.infrastructure.mapper.NoteMapper;
import com.notebox.service.NoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    @Override
    public Note createNote(NoteDto noteDto) {
        return noteRepository.save(NoteMapper.INSTANCE.noteDtoToNote(noteDto));
    }

    @Override
    public Note updateNote(NoteDto noteDto) {
        return noteRepository.save(NoteMapper.INSTANCE.noteDtoToNote(noteDto));
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
