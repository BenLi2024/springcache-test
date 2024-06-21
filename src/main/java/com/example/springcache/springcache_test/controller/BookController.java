package com.example.springcache.springcache_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.springcache.springcache_test.entity.Book;
import com.example.springcache.springcache_test.repository.BookRepository;

// Enable this class as a Spring Rest controller
// Add a method to get a book by its ISBN
// Use the BookRepository class to get the book
@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        Book book2 = bookRepository.findByIsbn(isbn);
        if(book != book2) {
            System.out.println("Spring cache is not working properly");
        } 
        return book2;
    }
}
