package com.day2class_exercise1.d2_ce1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.day2class_exercise1.d2_ce1.config.AppConfig;

@RestController
public class ApiController {
    @Autowired
    public AppConfig appConfig;

    @GetMapping("/path")
    public String getConfig() {
        return "AppName: "+appConfig.getName()+"\nVersion: "+appConfig.getVersion();
    }
}
