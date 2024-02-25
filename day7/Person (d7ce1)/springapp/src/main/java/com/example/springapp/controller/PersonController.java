package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Person;
import com.example.springapp.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonController {
    
    @Autowired
    private PersonService personService;

    @PostMapping("/person")
    public ResponseEntity<Person> postPerson(@RequestBody Person person)
    {
        if(personService.savePerson(person))
        {
            return new ResponseEntity<Person>(person, HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/person")
    public ResponseEntity<List<Person>> getAll(){
        List<Person> personList = personService.getAll();
        if(personList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    @GetMapping("/person/byAge")
    public ResponseEntity<List<Person>> getByAge(@RequestParam int age){
        List<Person> list = personService.getByAge(age);
        if(list.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Person>>(list, HttpStatus.OK);
    }
}
