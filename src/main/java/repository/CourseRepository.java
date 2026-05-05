package com.example.beadando.repository;
import com.example.beadando.model.Course;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class CourseRepository {
    private final List<Course> courses = new ArrayList<>();
    private Long nextId = 1L;
    public Course save(Course c) { if(c.getId()==null) c.setId(nextId++); courses.add(c); return c; }
    public List<Course> findAll() { return new ArrayList<>(courses); }
}
