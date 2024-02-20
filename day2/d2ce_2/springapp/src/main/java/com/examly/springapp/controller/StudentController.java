package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Student;

@RestController
public class StudentController {
    @GetMapping("/student")
    public Student getStudent() {
        Student student = new Student();
        student.setName("Nithish");
        student.setAge("22");
        return student;
    }
}
