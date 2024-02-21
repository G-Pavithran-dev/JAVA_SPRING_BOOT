package com.example.springapp.model;

import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
   @Id
    private int employeeId;
    private String firstName;
    private String LastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private Date hireDate;

    public Employee() {
    }

    public Employee(int employeeId, String firstName, String lastName, String email, String phoneNumber, String address,
            String city, Date hireDate) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.hireDate = hireDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
