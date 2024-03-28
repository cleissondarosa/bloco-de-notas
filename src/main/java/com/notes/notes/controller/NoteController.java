package com.notes.notes.controller;

import com.notes.notes.entity.EntityNote;
import com.notes.notes.entity.EntityNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private EntityNoteService noteService;

    @GetMapping
    public ResponseEntity<List<EntityNote>> getAllNotes() {
        List<EntityNote> notes = noteService.getAllNotes();
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityNote> getNoteById(@PathVariable Long id) {
        Optional<EntityNote> note = noteService.getNoteById(id);
        return note.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EntityNote> createNote(@RequestBody EntityNote note) {
        EntityNote createdNote = noteService.createOrUpdateNote(note);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNote);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityNote> updateNote(@PathVariable Long id, @RequestBody EntityNote note) {
        if (!noteService.getNoteById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        note.setId(id);
        EntityNote updatedNote = noteService.createOrUpdateNote(note);
        return ResponseEntity.ok(updatedNote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoteById(@PathVariable Long id) {
        if (!noteService.getNoteById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        noteService.deleteNoteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/api/notes", produces = MediaType.TEXT_HTML_VALUE)
    public String getNotasAsHtml() {
        // Aqui você retornaria o HTML com as notas formatadas
        return "<html><body><h1>Minhas Notas</h1><p>Nota 1</p><p>Nota 2</p></body></html>";
    }
}
