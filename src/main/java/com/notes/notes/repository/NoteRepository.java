package com.notes.notes.repository;

import com.notes.notes.entity.EntityNote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<EntityNote, Long>{

    List<EntityNote> findByTitle(String title);
    List<EntityNote> findByTitleContaining(String keyword);

}
