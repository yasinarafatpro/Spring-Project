package com.example.springTestProject.controller;


import com.example.springTestProject.entity.Student;
import com.example.springTestProject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/private")
public class HomeController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping
    public String goHome(){
        Student student = new Student();
        student.setName("Sakib");
        student.setDept("ICT");
        studentRepository.save(student);
        return "Welcome to Home Page";
    }

    @GetMapping("/profile")
    public String goProfile(){
        return "This is profile page";
    }
    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }
}
