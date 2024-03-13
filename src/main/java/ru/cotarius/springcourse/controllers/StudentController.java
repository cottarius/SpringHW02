package ru.cotarius.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.cotarius.springcourse.model.Student;
import ru.cotarius.springcourse.model.StudentRepository;

import java.util.List;

@RestController
public class StudentController {
    StudentRepository repository;

    @Autowired
    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/student")
    public List<Student> getAll(){
        return repository.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public Student getById(@PathVariable int id){
        return repository.getById(id);
    }
    @GetMapping("/group/{groupName}/student")
    public List<Student> getByGroupName(@PathVariable String groupName){
        return repository.getByGroupName(groupName);
    }
    @GetMapping("/student/search")
    public List<Student> getByName(@RequestParam String name){
        return repository.getByName(name);
    }
}
