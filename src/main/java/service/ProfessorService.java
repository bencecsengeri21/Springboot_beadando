package com.example.beadando.service;

import com.example.beadando.model.Professor;
import com.example.beadando.repository.ProfessorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfessorService {
    private final ProfessorRepository repo;

    // Az IntelliJ automatikusan injektálja a repository-t
    public ProfessorService(ProfessorRepository repo) {
        this.repo = repo;
    }

    public Professor create(Professor p) {
        return repo.save(p);
    }

    public List<Professor> getAll() {
        return repo.findAll();
    }
}
