package com.lms.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.lms.lms.entity.Book;
import com.lms.lms.repository.BookRepository;

@Controller
public class LibraryController {

    @Autowired
    private BookRepository bookRepo;

    // DASHBOARD
    @GetMapping("/")
    public String dashboard(@RequestParam(required = false) String genre,
                            Model model,
                            Authentication authentication) {
        // If not logged in, redirect to /signin
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/signin";
        }

        List<Book> books;
        if (genre != null && !genre.isEmpty()) {
            books = bookRepo.findByGenre(genre); 
        } else {
            books = bookRepo.findAll(); 
        }

        model.addAttribute("books", books);
        model.addAttribute("genres", bookRepo.findUniqueGenres());
        return "index";
    }

    // SAVE BOOK
    @PostMapping("/save")
    public String saveBook(Book book, Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/signin";
        }
        bookRepo.save(book);
        return "redirect:/";
    }

    // EDIT BOOK
  

    // DELETE BOOK
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id, Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/signin";
        }

        bookRepo.deleteById(id);
        return "redirect:/";
    }
}