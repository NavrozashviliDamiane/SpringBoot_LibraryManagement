package com.libmanagement.librarymanagementsystem.repository;

import com.libmanagement.librarymanagementsystem.entity.Book;
import com.libmanagement.librarymanagementsystem.entity.Patron;
import com.libmanagement.librarymanagementsystem.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Custom Query Method: Find transactions by book
    List<Transaction> findByBook(Book book);

    // Custom Query Method: Find transactions by patron
    List<Transaction> findByPatron(Patron patron);

    // Custom Query Method: Find transactions by overdue status
    List<Transaction> findByOverdue(boolean overdue);



}
