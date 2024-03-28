package com.notes.notes.model;

public class NoteRequest {
    private String title;
    private String content;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NoteRequest(String title, String content) {
        this.title = title;
        this.content = content;
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
