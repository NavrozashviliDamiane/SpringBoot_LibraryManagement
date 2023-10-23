package com.libmanagement.librarymanagementsystem.service.bookService;

import com.libmanagement.librarymanagementsystem.entity.Book;
import com.libmanagement.librarymanagementsystem.repository.BookRepository;
import com.libmanagement.librarymanagementsystem.utility.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookUpdateService {

    private BookRepository bookRepository;

    @Autowired
    public BookUpdateService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    @Transactional
    public Book updateBook(Long bookId, Book updatedBook) {
        // Step 1: Check if the book with the specified ID exists
        Book existingBook = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book not found"));


        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setIsbn(updatedBook.getIsbn());
        existingBook.setGenre(updatedBook.getGenre());

        // Save the updated book to the database
        Book savedBook = bookRepository.save(existingBook);

        return savedBook;
    }


}
