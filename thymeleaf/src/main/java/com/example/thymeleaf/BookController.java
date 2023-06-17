package com.example.thymeleaf;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private List<Book> books;

    public BookController(){
        books = new ArrayList<>();
        books.add(new Book("harry potter", "j.k.rowling"));
        books.add(new Book("We", "zamaytin"));
    }

    @GetMapping("/{id}")
    public String getSingleBook(Model model, @PathVariable("id") int id){
        model.addAttribute("book", books.get(id));
        return "book";
    }

    @GetMapping
    public String getAllBooks(Model model){
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/new")
    public String getNewBookForm(Model model){
        model.addAttribute("newBook", new Book());
        return "newBook";
    }
    @PostMapping("/new")
    public String createNewBookForm(Book book){
        books.add(book);
        return "/books";
    }
}
