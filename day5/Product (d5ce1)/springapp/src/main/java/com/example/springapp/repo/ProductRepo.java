package com.example.springapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
    
}
