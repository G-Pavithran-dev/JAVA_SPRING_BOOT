package com.reqparam.request_param_example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @GetMapping("/path")
    public String Path(@RequestParam String name) {
        return "Hello " + name;
    }
}