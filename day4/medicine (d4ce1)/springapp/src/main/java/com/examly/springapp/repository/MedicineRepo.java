package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.model.Medicine;

public interface MedicineRepo extends JpaRepository<Medicine, Integer>{
    
}
