package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentRepository repo;

    // CREATE
    @PostMapping
    public Student create(@RequestBody Student student) {
        return repo.save(student);
    }

    // READ ALL
    @GetMapping
    public List<Student> getAll() {
        return repo.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Student update(@PathVariable int id, @RequestBody Student student) {
        Student s = repo.findById(id).orElse(null);
        s.setName(student.getName());
        s.setEmail(student.getEmail());
        s.setAge(student.getAge());
        return repo.save(s);
    }
    // testing
    @PostMapping("/test")
    public String test() {
        return "POST WORKING";
    }


    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        repo.deleteById(id);
    }
}