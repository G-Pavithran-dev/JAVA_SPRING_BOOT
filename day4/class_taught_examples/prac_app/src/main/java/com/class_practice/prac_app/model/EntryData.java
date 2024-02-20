package com.class_practice.prac_app.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EntryData {
    
    @Id
    private int id;
    private String rollNo;
    private String name;
    private Date entryTime;
    private Date exitTime;
    
    public EntryData() {
    }
    public EntryData(int id, String rollNo, String name, Date entryTime, Date exitTime) {
        this.id = id;
        this.rollNo = rollNo;
        this.name = name;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRollNo() {
        return rollNo;
    }
    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getEntryTime() {
        return entryTime;
    }
    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }
    public Date getExitTime() {
        return exitTime;
    }
    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    
}
