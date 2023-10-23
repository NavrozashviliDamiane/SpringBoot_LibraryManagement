package com.libmanagement.librarymanagementsystem.service.bookService;

import com.libmanagement.librarymanagementsystem.entity.Book;
import com.libmanagement.librarymanagementsystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GetAllBookService {



    private BookRepository bookRepository;

    @Autowired
    public GetAllBookService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }



    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }
}
