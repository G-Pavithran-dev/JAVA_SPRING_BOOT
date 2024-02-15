package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Book;

@RestController
public class BookController {
    @Autowired
    private Book book;

    @GetMapping("/book")
    public Book getBook() {
        return book;
    }
}