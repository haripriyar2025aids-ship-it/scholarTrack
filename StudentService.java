package com.scholartrack.service;

import com.scholartrack.entity.Student;
import com.scholartrack.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repo;
    public StudentService(StudentRepository repo){ this.repo=repo; }
    public List<Student> all(){ return repo.findAll(); }
    public Student get(Long id){ return repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found")); }
    public Student save(Student s){ return repo.save(s); }
    public Student update(Long id, Student s){ Student old=get(id); s.setId(old.getId()); return repo.save(s); }
    public void delete(Long id){ repo.deleteById(id); }
}
