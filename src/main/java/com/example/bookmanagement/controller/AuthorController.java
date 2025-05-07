package com.example.bookmanagement.controller;

import com.example.bookmanagement.entity.Author;
import com.example.bookmanagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    
    @GetMapping
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        model.addAttribute("authorBooks", authorService.getAuthorsWithBooks());
        return "list-authors";
    }
    
    @GetMapping("/add")
    public String showAddAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "add-author";
    }
    
    @PostMapping
    public String addAuthor(@ModelAttribute Author author, Model model) {
        try {
            authorService.saveAuthor(author);
            return "redirect:/authors";
        } catch (Exception e) {
            model.addAttribute("error", "Error saving author: " + e.getMessage());
            return "add-author";
        }
    }
    
    @GetMapping("/update/{id}")
    public String showUpdateAuthorForm(@PathVariable Long id, Model model) {
        authorService.getAuthorById(id).ifPresent(author -> model.addAttribute("author", author));
        return "update-author";
    }
    
    @PostMapping("/update")
    public String updateAuthor(@ModelAttribute Author author, Model model) {
        try {
            authorService.saveAuthor(author);
            return "redirect:/authors";
        } catch (Exception e) {
            model.addAttribute("error", "Error updating author: " + e.getMessage());
            return "update-author";
        }
    }
}