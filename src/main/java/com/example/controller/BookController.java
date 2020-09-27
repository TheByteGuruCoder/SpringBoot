package com.example.controller;

import com.example.model.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String rootPage(){
        return "index";
    }


    @RequestMapping(value = "/allBooks", method = RequestMethod.GET)
    public String findAll(Model model){
        List<Book> allBooks = bookService.findAll();
        model.addAttribute("listBooks", allBooks);
        return "allBooks";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public String createBookForm(Book book){
        return "addBook";
    }

    @PostMapping("/addBook")
    public String addBook(Book book){
        bookService.saveBook(book);
        return "addBook";
    }

    @RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") Long id){
        bookService.deleteById(id);
        return "redirect:/allBooks";
    }

    @GetMapping("/edit/{id}")
    public String updateBookForm(@PathVariable("id") Long id, Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "updateBook";
    }
    @PostMapping("/update-book")
    public String updateUser(Book book){
        bookService.saveBook(book);
        return "redirect:/allBooks";
    }

}
