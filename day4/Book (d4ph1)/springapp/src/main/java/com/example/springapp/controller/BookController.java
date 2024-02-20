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

import com.example.springapp.model.Book;
import com.example.springapp.services.BookServices;

@RestController
@RequestMapping("/api")
public class BookController {
    
    private BookServices bookServices;
    public BookController(BookServices bookServices)
    {
        this.bookServices = bookServices;
    }

    @PostMapping("/book")
    public ResponseEntity<Book> addData(@RequestBody Book book)
    {
        if(bookServices.addBook(book))
        {
            return new ResponseEntity<Book>(book, HttpStatus.CREATED);
        }
        else{
            System.out.println("Cannot add Object");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/book")
    public ResponseEntity<List<Book>> getList()
    {
        List<Book> books = bookServices.getBooks();
        if(books.size() > 0)
        {
            return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<Book> getbookById(@PathVariable int bookId){
        Book book = bookServices.getBookById(bookId);
        if(book != null)
        {
            return new ResponseEntity<Book>(book, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
