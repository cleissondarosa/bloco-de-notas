package com.notes.notes.controller;

import com.notes.notes.entity.EntityNote;
import com.notes.notes.model.NoteRequest;
import com.notes.notes.model.NoteResponse;
import com.notes.notes.repository.NoteRepository;
import com.notes.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository entityNoteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.entityNoteRepository = noteRepository;
    }

    @Override
    public List<EntityNote> getAllNotes() {
        return entityNoteRepository.findAll();
    }

    @Override
    public Optional<EntityNote> getNoteById(Long id) {
        return entityNoteRepository.findById(id);
    }

    @Override
            /// verifica se está nulo
    public EntityNote createOrUpdateNote(NoteRequest noteRequest) {
        if (noteRequest == null || noteRequest.getTitle() == null || noteRequest.getContent() == null) {
            throw new IllegalArgumentException("NoteRequest cannot be null and must have non-null title and content.");
        }

        EntityNote newNote = new EntityNote();
        newNote.setTitle(noteRequest.getTitle());
        newNote.setContent(noteRequest.getContent());

        return entityNoteRepository.save(newNote);
    }

    @Override
    public void deleteNoteById(Long id) {
        entityNoteRepository.deleteById(id);

    }
}
