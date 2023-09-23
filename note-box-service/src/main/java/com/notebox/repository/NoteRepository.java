package com.notebox.repository;

import com.notebox.model.Note;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends ListCrudRepository<Note, Long> {
    List<Note> findByTitleContaining(String title);
}
