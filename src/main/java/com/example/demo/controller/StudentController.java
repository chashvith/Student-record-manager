package com.example.demo.controller;

import com.example.demo.Entity.StudentEntity;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<StudentEntity> getAll() {
        return service.getAllStudents();
    }

    @PostMapping
    public StudentEntity add(@RequestBody StudentEntity s) {
        return service.addStudent(s);
    }

    @GetMapping("/{id}")
    public StudentEntity getById(@PathVariable String id) {
        return service.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteStudent(id);
    }
}