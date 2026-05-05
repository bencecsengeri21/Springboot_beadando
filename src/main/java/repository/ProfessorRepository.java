package com.example.beadando.repository;

import com.example.beadando.model.Professor;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfessorRepository {
    private final List<Professor> professors = new ArrayList<>();
    private Long nextId = 1L;

    public Professor save(Professor p) {
        if (p.getId() == null) {
            p.setId(nextId++);
        }
        professors.add(p);
        return p;
    }

    public List<Professor> findAll() {
        return new ArrayList<>(professors);
    }
}
