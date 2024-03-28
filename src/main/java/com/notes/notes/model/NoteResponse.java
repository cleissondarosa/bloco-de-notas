package com.notes.notes.model;

import com.notes.notes.entity.EntityNote;
import com.notes.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class NoteResponse {
    private final NoteRepository noteRepository;
    private Long id;
    private String title;
    private String content;

    @Autowired
    public NoteResponse(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public EntityNote createNote(NoteRequest noteRequest) {
        EntityNote newNote = new EntityNote();
        newNote.setTitle(noteRequest.getTitle());
        newNote.setContent(noteRequest.getContent());

        // Salvar a nota no banco de dados
        return noteRepository.save(newNote);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}