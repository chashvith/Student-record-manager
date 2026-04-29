package com.example.demo.service;

import com.example.demo.Entity.StudentEntity;
import com.example.demo.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<StudentEntity> getAllStudents() {
        return repo.findAll();
    }

    public StudentEntity addStudent(StudentEntity student) {
        return repo.save(student);
    }

    public StudentEntity getStudentById(String id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteStudent(String id) {
        repo.deleteById(id);
    }
}