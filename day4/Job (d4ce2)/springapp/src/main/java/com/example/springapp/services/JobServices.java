package com.example.springapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.springapp.model.Job;
import com.example.springapp.repository.JobRepo;

@Service
public class JobServices {
    
    @Autowired
    private JobRepo jobRepo;

    public boolean addJob(Job job)
    {
        try{
            jobRepo.save(job);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public List<Job> getJobs()
    {
        return jobRepo.findAll();
    }

    public Job getJobById(int jobId)
    {
        return jobRepo.findById(jobId).orElse(null);
    }
}
