package com.example.bookmanagement.service;

import com.example.bookmanagement.entity.Author;
import com.example.bookmanagement.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {
    @Mock
    private AuthorRepository authorRepository;
    
    @InjectMocks
    private AuthorService authorService;
    
    @Test
    public void testGetAllAuthors() {
        Author author = new Author();
        author.setName("Test Author");
        when(authorRepository.findAll()).thenReturn(Arrays.asList(author));
        
        List<Author> authors = authorService.getAllAuthors();
        
        assertThat(authors).hasSize(1);
        assertThat(authors.get(0).getName()).isEqualTo("Test Author");
    }
}