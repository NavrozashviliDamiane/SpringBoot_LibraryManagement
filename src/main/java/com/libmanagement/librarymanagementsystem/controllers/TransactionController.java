package com.libmanagement.librarymanagementsystem.controllers;



import com.libmanagement.librarymanagementsystem.entity.Book;
import com.libmanagement.librarymanagementsystem.entity.Patron;
import com.libmanagement.librarymanagementsystem.entity.Transaction;
import com.libmanagement.librarymanagementsystem.repository.BookRepository;
import com.libmanagement.librarymanagementsystem.repository.PatronRepository;
import com.libmanagement.librarymanagementsystem.service.transactionService.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final BookRepository bookRepository;

    private PatronRepository patronRepository;


    @Autowired
    public TransactionController(TransactionService transactionService, BookRepository bookRepository) {
        this.transactionService = transactionService;
        this.bookRepository = bookRepository;
        this.patronRepository = patronRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction createdTransaction = transactionService.createTransaction(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTransaction);
    }

    @DeleteMapping("/{transactionId}")
    public ResponseEntity<String> deleteTransaction(@PathVariable Long transactionId) {
        transactionService.deleteTransaction(transactionId);
        return ResponseEntity.status(HttpStatus.OK).body("Transaction with ID " + transactionId + " deleted successfully.");
    }

    @GetMapping("/all")
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return transactions;
    }

    @PutMapping("/{transactionId}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long transactionId, @RequestBody Transaction updatedTransaction) {
        Transaction updated = transactionService.updateTransaction(transactionId, updatedTransaction);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<Transaction>> findTransactionsByBook(@PathVariable Long bookId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);

        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            List<Transaction> transactions = transactionService.findTransactionsByBook(book);
            return ResponseEntity.ok(transactions);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
        }
    }

    @GetMapping("/patron/{patronId}")
    public ResponseEntity<List<Transaction>> findTransactionsByPatron(@PathVariable Long patronId) {
        Optional<Patron> patronOptional = patronRepository.findById(patronId);

        if (patronOptional.isPresent()) {
            Patron patron = patronOptional.get();
            List<Transaction> transactions = transactionService.findTransactionsByPatron(patron);
            return ResponseEntity.ok(transactions);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
        }
    }

    @GetMapping("/overdue")
    public List<Transaction> findOverdueTransactions() {
        List<Transaction> transactions = transactionService.findOverdueTransactions(true);
        return transactions;
    }
}





