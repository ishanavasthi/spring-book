package com.example.bookmanagement.repository;

import com.example.bookmanagement.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a, b FROM Author a JOIN a.books b")
    List<Object[]> findAuthorsWithBooks();
}