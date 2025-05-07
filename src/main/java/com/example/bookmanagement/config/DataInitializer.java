package com.example.bookmanagement.config;

import com.example.bookmanagement.entity.Author;
import com.example.bookmanagement.entity.Book;
import com.example.bookmanagement.repository.AuthorRepository;
import com.example.bookmanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    
    @Override
    public void run(String... args) {
        // Create 10 authors
        for (int i = 1; i <= 10; i++) {
            Author author = new Author();
            author.setName("Author " + i);
            author.setNationality("Nationality " + i);
            authorRepository.save(author);
            
            // Create a book for each author
            Book book = new Book();
            book.setTitle("Book " + i);
            book.setIsbn("ISBN" + i);
            book.setAuthor(author);
            bookRepository.save(book);
        }
    }
}