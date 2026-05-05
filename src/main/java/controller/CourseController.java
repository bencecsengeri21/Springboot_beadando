package com.example.beadando.controller;
import com.example.beadando.model.Course;
import com.example.beadando.service.CourseService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService service;
    public CourseController(CourseService service) { this.service = service; }
    @PostMapping
    public Course create(@RequestBody Course c) { return service.create(c); }
    @GetMapping
    public List<Course> list() { return service.getAll(); }
}