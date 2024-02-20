package com.examly.springapp.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class Department {
    
    @JsonProperty("department")
    @Value("BACHELOR OF TECHNOLOGY")
    private String departmentName;
    @JsonProperty("branch")
    @Value("INFORMATION TECHNOLOGYYYY")
    private String branch;

    public Department(){

    }

    public Department(String departmentName, String branch) {
        this.departmentName = departmentName;
        this.branch = branch;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
    
    
}
