package com.libmanagement.librarymanagementsystem.service.bookService;


import com.libmanagement.librarymanagementsystem.entity.Book;
import com.libmanagement.librarymanagementsystem.repository.BookRepository;
import com.libmanagement.librarymanagementsystem.utility.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetBookByIdService {

    private BookRepository bookRepository;

    @Autowired
    public GetBookByIdService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book not found"));
    }


}
