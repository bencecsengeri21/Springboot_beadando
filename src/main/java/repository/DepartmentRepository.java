package com.example.beadando.repository;

import com.example.beadando.model.Department;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {
    private final List<Department> departments = new ArrayList<>();
    private Long nextId = 1L;

    public Department save(Department d) {
        if (d.getId() == null) {
            d.setId(nextId++);
        }
        departments.add(d);
        return d;
    }

    public List<Department> findAll() {
        return new ArrayList<>(departments);
    }
}