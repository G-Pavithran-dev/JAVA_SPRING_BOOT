package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepo;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepo personRepository;

    public PersonService(PersonRepo personRepository) {
        this.personRepository = personRepository;
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person getPersonById(int id) {
        return personRepository.findById(id).orElse(null);
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public boolean updatePerson(int id, Person person) {
        if(getPersonById(id) != null){ 
            personRepository.save(person);
            return true;
        }
        else{
            return false;
        }
    }

    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }
}
