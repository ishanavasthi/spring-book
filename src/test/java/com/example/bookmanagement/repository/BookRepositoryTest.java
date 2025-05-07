package com.example.bookmanagement.repository;

import com.example.bookmanagement.entity.Author;
import com.example.bookmanagement.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    
    @Test
    public void testSaveBook() {
        Author author = new Author();
        author.setName("Test Author");
        author.setNationality("Test Nationality");
        authorRepository.save(author);
        
        Book book = new Book();
        book.setTitle("Test Book");
        book.setIsbn("TEST123");
        book.setAuthor(author);
        Book savedBook = bookRepository.save(book);
        
        assertThat(savedBook.getId()).isNotNull();
        assertThat(savedBook.getTitle()).isEqualTo("Test Book");
    }
}