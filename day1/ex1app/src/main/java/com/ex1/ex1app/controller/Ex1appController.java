package com.ex1.ex1app.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController //it is called annotation it ensures this file is "controller";
// task 1
public class Ex1appController {
    @RequestMapping("/hello") //this is for "signle request or direct request" i.e. localhost:8080/hello
    public String Greeting() {
        return "Welcome hello world";
    }
}

// @RequestMapping("/hello")// if this annotation is above public class, it act as central req(i.e) all req comes under /hello 
// public class Ex1appController {
//     @GetMapping("/pranav")
//     public String Greeting() {
//         return "Pranav Hello World";
//     }
//     @GetMapping("/pavi")
//     public String GreetingPavi() {
//         return "Pavithran Hello";
//     }
// }