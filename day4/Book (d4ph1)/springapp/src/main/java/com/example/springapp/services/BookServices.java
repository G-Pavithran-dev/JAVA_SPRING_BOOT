package com.example.springapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.springapp.model.Book;
import com.example.springapp.repository.BookRepo;

@Service
public class BookServices {
    
    @Autowired
    private BookRepo bookRepo;

    public boolean addBook(Book book)
    {
        try{
            bookRepo.save(book);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public List<Book> getBooks()
    {
        return bookRepo.findAll();
    }

    public Book getBookById(int bookId)
    {
        return bookRepo.findById(bookId).orElse(null);
    }
}
