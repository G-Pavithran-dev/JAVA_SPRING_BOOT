package com.post_example.post_mapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.post_example.post_mapping.model.*;;


@RestController

// //basic posting in string format

// public class ApiController {
//     @PostMapping("/path")
//     public String postMapping(@RequestBody String entity) {
//         return entity + "Post Mapping Received!";
//     }
// }

public class ApiController{
    @Autowired
    private Model model;
    
    @PostMapping("/path")
    public Model postMapping(@RequestBody Model entity) {
        model.setId(entity.getId());
        model.setName(entity.getName());
        
        return model;
    }
}
