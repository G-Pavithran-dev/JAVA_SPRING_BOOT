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

import com.example.springapp.model.Job;
import com.example.springapp.services.JobServices;

@RestController
@RequestMapping("/api")
public class JobController {
    
    private JobServices jobServices;
    public JobController(JobServices jobServices)
    {
        this.jobServices = jobServices;
    }

    @PostMapping("/job")
    public ResponseEntity<Job> addData(@RequestBody Job job)
    {
        if(jobServices.addJob(job))
        {
            return new ResponseEntity<Job>(job, HttpStatus.CREATED);
        }
        else{
            System.out.println("Cannot add Object");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/job")
    public ResponseEntity<List<Job>> getList()
    {
        List<Job> jobs = jobServices.getJobs();
        if(jobs.size() > 0)
        {
            return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<Job> getJobById(@PathVariable int jobId){
        Job job = jobServices.getJobById(jobId);
        if(job != null)
        {
            return new ResponseEntity<Job>(job, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
