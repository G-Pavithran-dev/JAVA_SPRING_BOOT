package com.serviceex.serviceexample.controller;

import org.springframework.web.bind.annotation.RestController;

import com.serviceex.serviceexample.service.BusinesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.serviceex.serviceexample.model.StudentModel;



@RestController
public class ServieController {

    @Autowired
    private BusinesService Service;

    @GetMapping("/path")
    public List<StudentModel> getStudents() {
        Service.students.add(new StudentModel("Pavi", "126"));
        Service.students.add(new StudentModel("Parthi", "125"));
        Service.students.add(new StudentModel("Nivash", "124"));

        return Service.students;
    }
}