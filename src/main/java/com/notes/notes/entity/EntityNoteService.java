package com.notes.notes.entity;

import com.notes.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class EntityNoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<EntityNote> getAllNotes() {
        return noteRepository.findAll();
    }

    public Optional<EntityNote> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    public EntityNote createOrUpdateNote(EntityNote note) {
        return noteRepository.save(note);
    }

    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }
}
