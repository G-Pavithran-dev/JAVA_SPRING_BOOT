package com.skcet.sem_lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skcet.sem_lab.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
}
