package com.example.beadando.service;
import com.example.beadando.model.Course;
import com.example.beadando.repository.CourseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepository repo;
    public CourseService(CourseRepository repo) { this.repo = repo; }
    public Course create(Course c) { return repo.save(c); }
    public List<Course> getAll() { return repo.findAll(); }
}
