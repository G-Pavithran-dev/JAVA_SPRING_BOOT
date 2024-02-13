package com.valueannonation.value_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valueannonation.value_demo.model.BusinessModel;

@RestController
public class ApiController {
    @Autowired
    private BusinessModel bu;

    @GetMapping("/path")
    public BusinessModel path() {
        return bu;
    }
}
