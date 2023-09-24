package unit;

import com.notebox.dto.NoteDto;
import com.notebox.model.Note;
import com.notebox.repository.NoteRepository;
import com.notebox.service.impl.NoteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class NoteServiceUnitTest {
    @Mock
    private NoteRepository noteRepository;
    @InjectMocks
    private NoteServiceImpl noteService;
    @BeforeEach
    public void init() {MockitoAnnotations.openMocks(this);}

    @Test
    void createNoteMethodShouldReturnSavedNote(){
        // given
        NoteDto noteDto = new NoteDto(null, "example", "example content");
        Note note = buildNote(1L, "example", "example content");
        when(noteRepository.save(any(Note.class))).thenReturn(note);

        // when
        Note resultNote = noteService.createNote(noteDto);

        // then
        assertNotNull(resultNote);
        assertEquals(note, resultNote);
        verify(noteRepository, times(1)).save(any(Note.class));
    }

    @Test
    void updateNoteMethodShouldReturnUpdatedNote(){
        // given
        NoteDto noteDto = new NoteDto(1L, "example", "example content");
        Note note = buildNote(1L, "example", "example content");
        when(noteRepository.save(any(Note.class))).thenReturn(note);

        // when
        Note resultNote = noteService.updateNote(noteDto);

        // then
        assertNotNull(resultNote);
        assertEquals(note, resultNote);
        verify(noteRepository, times(1)).save(any(Note.class));
    }

    @Test
    void deleteNoteMethodShould(){
        // given
        Long id = 1L;

        // when
        Long resultId = noteService.deleteNote(1L);

        // then
        assertNotNull(resultId);
        verify(noteRepository, times(1)).deleteById(id);
    }

    @Test
    void getAllNoteMethodShouldReturnAllNotes(){
        // given
        List<Note> notes = List.of(
                buildNote(1L, "exampleA", "example content A"),
                buildNote(2L, "exampleB", "example content B"),
                buildNote(3L, "exampleC", "example content C"));
        when(noteRepository.findAll()).thenReturn(notes);

        // when
        List<Note> resultNotes = noteService.getAllNotes();

        // then
        assertNotNull(resultNotes);
        assertEquals(resultNotes.size(), 3);
        assertEquals(resultNotes, notes);
        verify(noteRepository, times(1)).findAll();
    }

    @Test
    void getAllNotesByTitleMethodShouldReturnNotesWithTitlePattern(){
        // given
        String pattern = "DD";
        List<Note> notes = List.of(
                buildNote(1L, "exampleDD", "example content A"),
                buildNote(2L, "exaDDmple", "example content B"));
        when(noteRepository.findByTitleContaining(pattern)).thenReturn(notes);

        // when
        List<Note> resultNotes = noteService.getAllNotesByTitle(pattern);

        // then
        assertNotNull(resultNotes);
        assertEquals(resultNotes.size(), 2);
        assertEquals(resultNotes, notes);
        verify(noteRepository, times(1)).findByTitleContaining(any(String.class));
    }

    private Note buildNote(Long id, String title, String content){
        return Note.builder()
                .id(id)
                .title(title)
                .content(content)
                .date(LocalDateTime.of(2023, Month.APRIL, 1, 1, 10))
                .build();
    }

}
