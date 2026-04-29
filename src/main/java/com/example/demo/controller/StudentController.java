package com.example.demo.controller;

import com.example.demo.Entity.StudentEntity;
import com.example.demo.Repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<StudentEntity> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public StudentEntity add(@RequestBody StudentEntity s) {
        return repo.save(s);
    }

    @GetMapping("/{id}")
    public StudentEntity getById(@PathVariable String id) {
        return repo.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}