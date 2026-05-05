package com.example.beadando.service;

import com.example.beadando.model.Department;
import com.example.beadando.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository repo;

    public DepartmentService(DepartmentRepository repo) {
        this.repo = repo;
    }

    public Department create(Department d) {
        return repo.save(d);
    }

    public List<Department> getAll() {
        return repo.findAll();
    }
}
