package com.class_practice.prac_app.services;

import org.springframework.stereotype.Service;
import com.class_practice.prac_app.model.*;
import com.class_practice.prac_app.repository.StudentRepository;

@Service
public class StudentService {

    // we're using constructor injection
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public StudentDetails saveStudent(StudentDetails studentDetails)
    {
        // do the action at repository
        studentRepository.save(studentDetails);
        return studentDetails;
    }
}
