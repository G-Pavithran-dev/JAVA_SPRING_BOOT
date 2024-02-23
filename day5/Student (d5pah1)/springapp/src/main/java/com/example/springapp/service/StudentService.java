package com.example.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springapp.model.Student;
import com.example.springapp.repository.StudentRepo;

@Service
public class StudentService {
    
    private StudentRepo studentRepo;
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public boolean saveStudent(Student student) {
        try{
            studentRepo.save(student);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    public Student getStudentById(int studentId) {
        return studentRepo.findById(studentId).orElse(null);
    }
    
    public Student updateStudent(int studentId, Student student) {
        if(this.getStudentById(studentId) == null)
            return null;

        try{
            studentRepo.save(student);
            return student;
        }
        catch(Exception e) {
            return null;
        }
    }

    public boolean deleteStudent(int studentId) {
        if(this.getStudentById(studentId) == null)
            return false;

        try{
            studentRepo.deleteById(studentId);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
}
