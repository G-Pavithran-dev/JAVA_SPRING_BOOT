package com.class_practice.prac_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.class_practice.prac_app.model.StudentDetails;

// change class to interface
// add extends JpaRepository<object, datatype of primary key>
@Repository
public interface StudentRepository extends JpaRepository<StudentDetails, Integer>
{
    
}
