package com.example.beadando.service;

import com.example.beadando.exception.EntityNotFoundException;
import com.example.beadando.exception.ValidationException;
import com.example.beadando.model.Student;
import com.example.beadando.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * ÚJ METÓDUS: Ez keresi meg a diákot ID alapján a 10. tesztponthoz.
     * Ha nincs meg, dobja az EntityNotFoundException-t.
     */
    public Student findById(Long id) {
        return studentRepository.findAll().stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + id));
    }

    /**
     * Új objektum felvitele (A POST kérésekhez)
     */
    public Student createStudent(Student student) {
        if (student.getName() == null || student.getName().isEmpty()) {
            throw new ValidationException("A diák neve nem lehet üres!");
        }
        return studentRepository.save(student);
    }

    /**
     * Objektumok listázása és szűrése
     */
    public List<Student> getAllStudents(String nameFilter) {
        List<Student> all = studentRepository.findAll();
        if (nameFilter != null && !nameFilter.isEmpty()) {
            return all.stream()
                    .filter(s -> s.getName().toLowerCase().contains(nameFilter.toLowerCase()))
                    .collect(Collectors.toList());
        }
        return all;
    }

    /**
     * Meglévő objektum módosítása (A PUT kéréshez)
     */
    public Student updateStudent(Long id, Student studentDetails) {
        // Itt az új findById metódust használjuk a kereséshez
        Student student = findById(id);

        student.setName(studentDetails.getName());
        student.setAge(studentDetails.getAge());
        student.setActive(studentDetails.isActive());

        return studentRepository.save(student);
    }

    /**
     * Meglévő objektum törlése
     */
    public void deleteStudent(Long id) {
        // Itt is ellenőrizzük, létezik-e mielőtt törölnénk
        findById(id);
        studentRepository.deleteById(id);
    }

    // Segédmetódus a korábbi Controller kódokhoz, ha máshol 'save' néven hivatkoztál rá
    public Student save(Student student) {
        return createStudent(student);
    }

    // Segédmetódus a korábbi Controller kódokhoz, ha máshol 'findAll' néven hivatkoztál rá
    public List<Student> findAll() {
        return getAllStudents(null);
    }
}