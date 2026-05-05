package com.example.beadando.repository;

import com.example.beadando.model.Student;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {
    private final List<Student> students = new ArrayList<>();
    private Long nextId = 1L;

    // 1. metódus: Mentés
    public Student save(Student student) {
        if (student.getId() == null) {
            student.setId(nextId++);
            students.add(student);
        } else {
            deleteById(student.getId());
            students.add(student);
        }
        return student;
    }

    // 2. metódus: Listázás
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    // 3. metódus: Törlés
    public void deleteById(Long id) {
        students.removeIf(s -> s.getId().equals(id));
    }

    // +1 Segédmetódus a kereséshez
    public Optional<Student> findById(Long id) {
        return students.stream().filter(s -> s.getId().equals(id)).findFirst();
    }
}
