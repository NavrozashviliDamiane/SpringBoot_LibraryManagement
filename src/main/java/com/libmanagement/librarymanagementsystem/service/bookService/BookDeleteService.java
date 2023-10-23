package com.libmanagement.librarymanagementsystem.service.bookService;


import com.libmanagement.librarymanagementsystem.repository.BookRepository;
import com.libmanagement.librarymanagementsystem.utility.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookDeleteService {

    private BookRepository bookRepository;

    @Autowired
    public BookDeleteService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    public void deleteBook(Long bookId) {
        if (!bookRepository.existsById(bookId)) {
            throw new BookNotFoundException("Book not found");
        }
        bookRepository.deleteById(bookId);
    }


}
