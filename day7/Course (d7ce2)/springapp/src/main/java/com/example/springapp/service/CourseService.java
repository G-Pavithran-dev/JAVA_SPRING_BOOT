package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Course;
import com.example.springapp.repository.CourseRepo;

@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;

    public boolean post(Course course)
    {
        try
        {
            courseRepo.save(course);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public List<Course> getAll()
    {
        return courseRepo.findAll();
    }

    public List<Course> getbyAge(String courseName)
    {
        return courseRepo.findByCourseName(courseName);
    }
    
}
