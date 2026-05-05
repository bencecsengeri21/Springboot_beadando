package com.example.beadando.controller;

import com.example.beadando.model.Professor;
import com.example.beadando.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professors")
public class ProfessorController {

    private final ProfessorService service;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @PostMapping
    public Professor create(@RequestBody Professor p) {
        return service.create(p);
    }

    @GetMapping
    public List<Professor> list() {
        return service.getAll();
    }
}