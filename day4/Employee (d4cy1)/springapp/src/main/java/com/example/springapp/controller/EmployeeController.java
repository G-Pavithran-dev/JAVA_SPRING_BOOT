package com.example.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Employee;
import com.example.springapp.services.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    
    private EmployeeService employeeServices;
    public EmployeeController(EmployeeService employeeServices)
    {
        this.employeeServices = employeeServices;
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> addData(@RequestBody Employee employee)
    {
        if(employeeServices.addemployee(employee))
        {
            return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
        }
        else{
            System.out.println("Cannot add Object");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getList()
    {
        List<Employee> employees = employeeServices.getemployees();
        if(employees.size() > 0)
        {
            return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<Employee> getemployeeById(@PathVariable int employeeId){
        Employee employee = employeeServices.getemployeeById(employeeId);
        if(employee != null)
        {
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
