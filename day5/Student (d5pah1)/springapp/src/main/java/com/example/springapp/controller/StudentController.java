package com.example.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Student;
import com.example.springapp.service.StudentService;

@RestController
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        if(studentService.saveStudent(student))
            return new ResponseEntity<>(student, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getStudents() {

        List<Student> studentList = studentService.getStudents();
        if(studentList.isEmpty())
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        else
            return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable("studentId") int studentId) {
        Student student = studentService.getStudentById(studentId);
        if(student == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        else
            return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("/student/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable("studentId") int studentId, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(studentId, student);
        if(updatedStudent != null)
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/student/{studentId}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable("studentId") int studentId) {
        if(studentService.deleteStudent(studentId))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
