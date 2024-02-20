package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.model.Department;

@RestController
public class DepartmentController {
    @Autowired
    private Department dept;

    @GetMapping("/department")
    public String getDepartment() {
        return "Department Name: " + dept.getDepartmentName() + ", Branch: " + dept.getBranch();
    }
}
