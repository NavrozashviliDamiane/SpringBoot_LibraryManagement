package com.libmanagement.librarymanagementsystem.controllers;

import com.libmanagement.librarymanagementsystem.entity.Book;
import com.libmanagement.librarymanagementsystem.entity.Transaction;
import com.libmanagement.librarymanagementsystem.service.bookService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookCreateService bookCreateService;
    private final BookDeleteService bookDeleteService;
    private final BookTransactionService bookTransactionService;
    private final BookUpdateService bookUpdateService;
    private final FindBookService findBookService;
    private final GetAllBookService getAllBookService;
    private final GetBookByIdService getBookByIdService;

    @Autowired
    public BookController(BookCreateService bookCreateService, BookDeleteService bookDeleteService,
                          BookTransactionService bookTransactionService, BookUpdateService bookUpdateService,
                          FindBookService findBookService, GetAllBookService getAllBookService,
                          GetBookByIdService getBookByIdService) {
        this.bookCreateService = bookCreateService;
        this.bookDeleteService = bookDeleteService;
        this.bookTransactionService = bookTransactionService;
        this.bookUpdateService = bookUpdateService;
        this.findBookService = findBookService;
        this.getAllBookService = getAllBookService;
        this.getBookByIdService = getBookByIdService;
    }

    @PostMapping("/create")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookCreateService.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Long bookId) {
        bookDeleteService.deleteBook(bookId);
        return ResponseEntity.status(HttpStatus.OK).body("Book with id " + bookId + " deleted successfully.");
    }



    @PutMapping("/return/{transactionId}")
    public ResponseEntity<Transaction> returnBook(@PathVariable Long transactionId) {
        Transaction transaction = bookTransactionService.returnBook(transactionId);
        return ResponseEntity.ok(transaction);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable Long bookId, @RequestBody Book updatedBook) {
        Book updated = bookUpdateService.updateBook(bookId, updatedBook);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/title/{title}")
    public List<Book> findBooksByTitle(@PathVariable String title) {
        return findBookService.findByTitle(title);
    }

    @GetMapping("/author/{author}")
    public List<Book> findBooksByAuthor(@PathVariable String author) {
        return findBookService.findByAuthor(author);
    }

    @GetMapping("/genre/{genre}")
    public List<Book> findBooksByGenre(@PathVariable String genre) {
        return findBookService.findByGenre(genre);
    }

    @GetMapping("/availability/{availability}")
    public List<Book> findBooksByAvailability(@PathVariable boolean availability) {
        return findBookService.findByAvailability(availability);
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return getAllBookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable String bookId) {
        Long bookIdLong = Long.parseLong(bookId);
        Book book = getBookByIdService.getBookById(bookIdLong);
        return ResponseEntity.ok(book);
    }
}
