package com.notes.notes.api;

import com.notes.notes.controller.NoteServiceImpl;
import com.notes.notes.entity.EntityNote;
import com.notes.notes.repository.NoteRepository;
import com.notes.notes.service.NoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NoteServiceTest {

    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    private NoteService noteService = new NoteServiceImpl(noteRepository);

    @BeforeEach
    public void setUp() {
        noteService = new NoteServiceImpl(noteRepository);
    }

    @Test
    public void testGetNoteById() {
        // Dado
        long noteId = 1L;
        EntityNote expectedNote = new EntityNote();
        expectedNote.setId(noteId);
        expectedNote.setTitle("Test Note");
        expectedNote.setContent("This is a test note");

        // Configuração do comportamento simulado do repositório
        when(noteRepository.findById(noteId)).thenReturn(Optional.of(expectedNote));

        // Quando
        Optional<EntityNote> actualNote = noteService.getNoteById(noteId);

        // Então
        assertEquals(expectedNote, actualNote.orElse(null));
    }
}
