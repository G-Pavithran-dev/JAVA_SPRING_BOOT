package com.skcet.sem_lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skcet.sem_lab.Model.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
    
    public List<Device> findByUserId(int id);
}
