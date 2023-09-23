package integr;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.notebox.NoteBoxServiceApplication;
import com.notebox.dto.NoteDto;
import com.notebox.repository.NoteRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@AutoConfigureMockMvc
@SpringBootTest(classes = NoteBoxServiceApplication.class)
@SqlGroup({
        @Sql(value = "classpath:queries/clear-all-notes.sql", executionPhase = BEFORE_TEST_METHOD),
        @Sql(value = "classpath:queries/prepare-test-notes.sql", executionPhase = BEFORE_TEST_METHOD)
})
class NoteControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createNoteShouldReturnNoteWithCreatedStatus() throws Exception {
        // given
        String title = "example";
        String content = "This is example note content";
        NoteDto noteDto = new NoteDto(null, title, content);

        // when,then
        mockMvc.perform(post("http://localhost:6000/v1/api/note/create")
                .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(noteDto)))
                .andExpect(jsonPath("$.title").value(title))
                .andExpect(jsonPath("$.content").value(content))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        assertThat(noteRepository.findAll()).hasSize(6);
    }

    @Test
    void createNoteShouldReturnBadRequestStatusFotNotValidTitle() throws Exception {
        // given
        String title = "az12345Z";
        String content = "This is example note content";
        NoteDto noteDto = new NoteDto(null, title, content);

        // when,then
        mockMvc.perform(post("http://localhost:6000/v1/api/note/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(noteDto)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createNoteShouldReturnBadRequestStatusFotNotValidContent() throws Exception {
        // given
        String title = "example";
        String content = "This is e@xample not#e content with special $ characters";
        NoteDto noteDto = new NoteDto(null, title, content);

        // when,then
        mockMvc.perform(post("http://localhost:6000/v1/api/note/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(noteDto)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void updateNoteShouldReturnUpdatedNoteFromDataBase() throws Exception {
        // given
        String title = "updatedTitle";
        String content = "example updated content";
        NoteDto noteDto = new NoteDto(102L, title, content);

        // when,then
        mockMvc.perform(put("http://localhost:6000/v1/api/note/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(noteDto)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(102))
                .andExpect(jsonPath("$.title").value(title))
                .andExpect(jsonPath("$.content").value(content))
                .andExpect(status().isOk());
        assertThat(noteRepository.findAll()).hasSize(5);
        assertEquals(noteRepository.findById(102L).orElseThrow().getTitle(), title);
    }

    @Test
    void deleteNoteShouldRemoveNoteFromDataBase() throws Exception {
        // given, when,then
        mockMvc.perform(delete("http://localhost:6000/v1/api/note/delete")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id", String.valueOf(4)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("4"))
                .andExpect(status().isOk());
    }

    @Test
    void getAllNotesShouldReturnFiveRecordsFromDataBase() throws Exception {
        // given, when, then
        mockMvc.perform(get("http://localhost:6000/v1/api/note/get/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", Matchers.hasSize(5)));
    }

    @Test
    void getAllNotesByTitleShouldReturnRecordWithMatchingTitles() throws Exception {
        // given
        String title = "DEV";

        // when, then
        mockMvc.perform(get("http://localhost:6000/v1/api/note/get/by/title")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("title", title))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", Matchers.hasSize(3)));
    }

}
