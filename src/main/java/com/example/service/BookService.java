package com.example.service;

import com.example.model.Book;
import com.example.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }
    public Book findById(Long id){
        return bookRepo.getOne((id));
    }

    public List<Book> findAll(){
        return bookRepo.findAll();
    }

    public Book saveBook(Book book){
        return bookRepo.save(book);
    }

    public void deleteById(Long id){
        bookRepo.deleteById((id));
    }

}
