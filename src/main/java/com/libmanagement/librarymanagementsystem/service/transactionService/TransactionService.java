package com.libmanagement.librarymanagementsystem.service.transactionService;


import com.libmanagement.librarymanagementsystem.entity.Book;
import com.libmanagement.librarymanagementsystem.entity.Patron;
import com.libmanagement.librarymanagementsystem.entity.Transaction;
import com.libmanagement.librarymanagementsystem.repository.TransactionRepository;
import com.libmanagement.librarymanagementsystem.utility.TransactionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;




    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public Transaction createTransaction(Transaction transaction) {
        // 1. Validation
        if (transaction == null || transaction.getBook() == null || transaction.getPatron() == null) {
            throw new IllegalArgumentException("Invalid Transaction: Missing required data.");
        }

        // 2. Business Logic (if needed)
        Book book = transaction.getBook();
        Patron patron = transaction.getPatron();





            Transaction savedTransaction = transactionRepository.save(transaction);

            return savedTransaction;

    }

    @Transactional
    public void deleteTransaction(Long transactionId) {

        transactionRepository.deleteById(transactionId);
    }

    public List<Transaction> getAllTransactions() {

        return transactionRepository.findAll();
    }

    @Transactional
    public Transaction updateTransaction(Long transactionId, Transaction updatedTransaction) {

        return updatedTransaction; // Return the updated transaction
    }

    public List<Transaction> findTransactionsByBook(Book book) {
        // Add logic to find transactions by book using the repository
        return transactionRepository.findByBook(book);
    }

    public List<Transaction> findTransactionsByPatron(Patron patron) {
        // Add logic to find transactions by patron using the repository
        return transactionRepository.findByPatron(patron);
    }

    public List<Transaction> findOverdueTransactions(boolean overdue) {
        // Add logic to find transactions by overdue status using the repository
        return transactionRepository.findByOverdue(overdue);
    }


}
