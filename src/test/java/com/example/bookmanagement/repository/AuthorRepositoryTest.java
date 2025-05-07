package com.example.bookmanagement.repository;

import com.example.bookmanagement.entity.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AuthorRepositoryTest {
    @Autowired
    private AuthorRepository authorRepository;
    
    @Test
    public void testSaveAuthor() {
        Author author = new Author();
        author.setName("Test Author");
        author.setNationality("Test Nationality");
        Author savedAuthor = authorRepository.save(author);
        
        assertThat(savedAuthor.getId()).isNotNull();
        assertThat(savedAuthor.getName()).isEqualTo("Test Author");
    }
}