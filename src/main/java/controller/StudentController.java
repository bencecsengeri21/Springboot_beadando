package com.example.beadando.controller;

import com.example.beadando.dto.StudentDTO;
import com.example.beadando.model.Student;
import com.example.beadando.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * 10. tesztpont javítása: GET /api/students/999
     * Fontos a @PathVariable("id"), hogy biztosan felismerje!
     */
    @GetMapping("/{id}")
    public StudentDTO getById(@PathVariable("id") Long id) {
        Student student = studentService.findById(id);
        return convertToDto(student);
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable("id") Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<StudentDTO> list(@RequestParam(required = false) String name) {
        return studentService.getAllStudents(name).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private StudentDTO convertToDto(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setAge(student.getAge());
        dto.setActive(student.isActive());
        dto.setEmailAddresses(student.getEmailAddresses());
        return dto;
    }
}