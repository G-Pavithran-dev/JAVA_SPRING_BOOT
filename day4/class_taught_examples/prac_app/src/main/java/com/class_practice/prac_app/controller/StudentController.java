package com.class_practice.prac_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.class_practice.prac_app.model.StudentDetails;
import com.class_practice.prac_app.services.StudentService;

@RestController
public class StudentController {
    // using autowired is known as field injection
    // @Autowired
    private StudentService studentService;

    // but good pratice is to use constructor injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/addStudent")
    public StudentDetails addStudent(@RequestBody StudentDetails studentDetails)
    {
        // call the service for save
        studentService.saveStudent(studentDetails);
        return studentDetails;
    }
}
