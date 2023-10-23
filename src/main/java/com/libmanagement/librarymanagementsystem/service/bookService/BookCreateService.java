package com.libmanagement.librarymanagementsystem.service.bookService;
import com.libmanagement.librarymanagementsystem.entity.Book;
import com.libmanagement.librarymanagementsystem.repository.BookRepository;
import com.libmanagement.librarymanagementsystem.utility.BookIsbnNotUniqueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookCreateService {

    private BookRepository bookRepository;

    @Autowired
    public BookCreateService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    @Transactional
    public Book createBook(Book book) {



        // Set availability to true (new books are assumed to be available)
        book.setAvailability(true);

        // Save the book to the database
        return bookRepository.save(book);
    }

}
