package com.notes.notes.api.service;

import com.notes.notes.entity.EntityNote;
import com.notes.notes.model.NoteRequest;
import com.notes.notes.model.NoteResponse;
import com.notes.notes.service.NoteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class NoteServiceIntegrationTest {

    @Autowired
    private NoteService noteService;

    @Test
    public void testCreateNote() {
        // Criar uma nova nota
        NoteRequest noteRequest = new NoteRequest("Test Title", "Test Content");
        EntityNote createNote = noteService.createOrUpdateNote(noteRequest); //

        // Verificar se a nota foi criada corretamente
        assertNotNull(createNote.getId());
        assertEquals("Test Title", createNote.getTitle());
        assertEquals("Test Content", createNote.getContent());
    }

    @Test
    public void testGetNoteById() {
        // Criar uma nova nota
        NoteRequest noteRequest = new NoteRequest("Test Title", "Test Content");
        EntityNote createdNote = noteService.createOrUpdateNote(noteRequest);

        // Buscar a nota pelo ID
        Long noteId = createdNote.getId();
        Optional<EntityNote> retrievedNoteOptional = noteService.getNoteById(noteId);
        assertTrue(retrievedNoteOptional.isPresent());
        EntityNote retrievedNote = retrievedNoteOptional.get();

        // Verificar se a nota foi encontrada corretamente
        assertNotNull(retrievedNote);
        assertEquals(createdNote.getId(), retrievedNote.getId());
        assertEquals("Test Title", retrievedNote.getTitle());
        assertEquals("Test Content", retrievedNote.getContent());
    }

    // Adicione mais testes para outras operações de CRUD (atualização, exclusão, etc.)
}
