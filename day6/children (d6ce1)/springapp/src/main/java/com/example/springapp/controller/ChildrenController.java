package com.example.springapp.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Children;
import com.example.springapp.service.ChildrenService;

@RestController
@RequestMapping("/api")
public class ChildrenController {
    
    private ChildrenService childrenService;
    public ChildrenController(ChildrenService childrenService)
    {
        this.childrenService = childrenService;
    }

    @PostMapping("/children")
    public ResponseEntity<Children> addChildren(@RequestBody Children children)
    {
        if(childrenService.addChildren(children))
        {
            return new ResponseEntity<Children>(children, HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/children/sortBy/{field}")
    public ResponseEntity<List<Children>> sortByField(@PathVariable("field") String field)
    {
        List<Children> children = childrenService.sortChildrens(field);
        if(children.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<List<Children>>(children, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/children/{offset}/{pagesize}")
    public ResponseEntity<List<Children>> getPages(@PathVariable("offset") int offset, @PathVariable("pagesize") int pagesize)
    {
        List<Children> children = childrenService.getPages(offset, pagesize);
        if(children.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<List<Children>>(children, HttpStatus.OK);
        }
    }

    @GetMapping("/children/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Children>> getSortedPages(@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize,@PathVariable("field") String field)
    {
        List<Children> pages = childrenService.getChildrens(offset, pagesize, field);

        if(pages.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<List<Children>>(pages, HttpStatus.OK);
        }
    }
}
