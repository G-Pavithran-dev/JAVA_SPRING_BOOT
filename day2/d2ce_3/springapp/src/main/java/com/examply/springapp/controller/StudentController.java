package com.examply.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examply.springapp.model.Student;

@RestController
public class StudentController {
    @Autowired
    private Student stu;

    @GetMapping("/student")
    public Student getStudent() {
        return stu;
    }
}
