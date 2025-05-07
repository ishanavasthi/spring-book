package com.example.bookmanagement.controller;

import com.example.bookmanagement.entity.Book;
import com.example.bookmanagement.service.AuthorService;
import com.example.bookmanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    
    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "list-books";
    }
    
    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "add-book";
    }
    
    @PostMapping
    public String addBook(@ModelAttribute Book book, Model model) {
        try {
            bookService.saveBook(book);
            return "redirect:/books";
        } catch (Exception e) {
            model.addAttribute("error", "Error saving book: " + e.getMessage());
            model.addAttribute("authors", authorService.getAllAuthors());
            return "add-book";
        }
    }
    
    @GetMapping("/update/{id}")
    public String showUpdateBookForm(@PathVariable Long id, Model model) {
        bookService.getBookById(id).ifPresent(book -> model.addAttribute("book", book));
        model.addAttribute("authors", authorService.getAllAuthors());
        return "update-book";
    }
    
    @PostMapping("/update")
    public String updateBook(@ModelAttribute Book book, Model model) {
        try {
            bookService.saveBook(book);
            return "redirect:/books";
        } catch (Exception e) {
            model.addAttribute("error", "Error updating book: " + e.getMessage());
            model.addAttribute("authors", authorService.getAllAuthors());
            return "update-book";
        }
    }
}