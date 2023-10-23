package com.libmanagement.librarymanagementsystem.service.bookService;




import com.libmanagement.librarymanagementsystem.entity.Book;
import com.libmanagement.librarymanagementsystem.entity.Patron;
import com.libmanagement.librarymanagementsystem.entity.Transaction;
import com.libmanagement.librarymanagementsystem.repository.BookRepository;
import com.libmanagement.librarymanagementsystem.repository.PatronRepository;
import com.libmanagement.librarymanagementsystem.repository.TransactionRepository;
import com.libmanagement.librarymanagementsystem.utility.BookNotFoundException;
import com.libmanagement.librarymanagementsystem.utility.PatronNotFoundException;
import com.libmanagement.librarymanagementsystem.utility.TransactionNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class BookTransactionService {

    private final BookRepository bookRepository;
    private final TransactionRepository transactionRepository;
    private final PatronRepository patronRepository;



    public Transaction borrowBook(Long patronId, Long bookId) {
        // Retrieve the patron and book from their respective repositories.
        Patron patron = patronRepository.findById(patronId)
                .orElseThrow(() -> new PatronNotFoundException("Patron not found"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book not found"));

        // Check if the book is available for borrowing.
        if (!book.isAvailability()) {
            throw new BookNotFoundException("Book is not available for borrowing");
        }

        // Create a transaction record.
        Transaction transaction = new Transaction();
        transaction.setPatron(patron);
        transaction.setBook(book);
        transaction.setBorrowDate(new Date());


        // Update book availability.
        book.setAvailability(false);
        bookRepository.save(book);

        // Save the transaction.
        transactionRepository.save(transaction);

        return transaction;
    }


    public Transaction returnBook(Long transactionId) {
        // Retrieve the transaction.
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found"));

        // Update the return date.
        transaction.setReturnDate(new Date());

        // Calculate if the book is overdue.
        if (new Date().after(transaction.getDueDate())) {
            transaction.setOverdue(true);
        }

        // Update book availability.
        Book book = transaction.getBook();
        book.setAvailability(true);
        bookRepository.save(book);

        // Save the updated transaction.
        transactionRepository.save(transaction);

        return transaction;
    }




}

