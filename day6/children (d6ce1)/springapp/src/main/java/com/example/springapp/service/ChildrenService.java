package com.example.springapp.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Children;
import com.example.springapp.repository.ChildrenRepo;

@Service
public class ChildrenService {
    
    private ChildrenRepo childrenRepo;
    public ChildrenService(ChildrenRepo childrenRepo)
    {
        this.childrenRepo = childrenRepo;
    }

    public boolean addChildren(Children children)
    {
        try{
            childrenRepo.save(children);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    public List<Children> getPages(int offset, int pageSize)
    {
        return childrenRepo.findAll(PageRequest.of(offset, pageSize)).getContent();
    }

    public List<Children> sortChildrens(String field)
    {
        return childrenRepo.findAll(Sort.by(Sort.Direction.DESC, field));
    }

    public List<Children> getChildrens(int offset, int pageSize, String field)
    {
        // Sort sort = Sort.by(Sort.Direction.ASC, field);
        // PageRequest pageRequest = PageRequest.of(offset, pageSize,sort);
        // return childrenRepo.findAll(pageRequest).getContent();
        return childrenRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(Sort.Direction.DESC, field))).getContent();
    }
}
