package com.notes.notes.service;

import com.notes.notes.entity.EntityNote;
import com.notes.notes.model.NoteRequest;
import com.notes.notes.model.NoteResponse;

import java.util.List;
import java.util.Optional;

public interface NoteService {

    List<EntityNote> getAllNotes();

    Optional<EntityNote> getNoteById(Long id);

    EntityNote createOrUpdateNote(NoteRequest noteRequest);

    void deleteNoteById(Long id);

}