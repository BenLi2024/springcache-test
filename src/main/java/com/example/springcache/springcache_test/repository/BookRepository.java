package com.example.springcache.springcache_test.repository;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.example.springcache.springcache_test.entity.Book;

@Component
public class BookRepository {
    
    @Cacheable(value = "book", key = "#isbn")
    public Book findByIsbn(String isbn) {
        System.out.println("Not found in cache, build a new one.");
        return new Book(isbn, "Any book", "Any book");
    }
}