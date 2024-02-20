package com.extraannotations.anno_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.extraannotations.anno_app.model.LoginCredentials;
import java.util.*;

@RestController
public class ApiController {
    @GetMapping("/path")
    public List<LoginCredentials> getCredentials() {

        List<LoginCredentials> credentials = new ArrayList<>();
        credentials.add(new LoginCredentials("user1", "pass1", "mail1"));
        credentials.add(new LoginCredentials("user2", "pass2", "mail2"));
        credentials.add(new LoginCredentials("user3", "pass3", "mail3"));
        return credentials;
    }
}
