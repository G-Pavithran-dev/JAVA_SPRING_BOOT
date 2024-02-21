package com.example.springapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.springapp.model.Employee;
import com.example.springapp.repository.EmployeeRepo;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepo employeeRepo;

    public boolean addemployee(Employee employee)
    {
        try{
            employeeRepo.save(employee);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public List<Employee> getemployees()
    {
        return employeeRepo.findAll();
    }

    public Employee getemployeeById(int employeeId)
    {
        return employeeRepo.findById(employeeId).orElse(null);
    }
}
