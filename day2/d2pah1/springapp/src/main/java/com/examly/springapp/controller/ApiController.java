package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.config.AppConfig;

@RestController
public class ApiController {
    @Autowired
    private AppConfig details;
    
    @GetMapping("/info")
    public String getInfo() {
        return "Student Name: "+details.getStudentName()+", Student Department: "+details.getStudentDepartment();
    }
}
