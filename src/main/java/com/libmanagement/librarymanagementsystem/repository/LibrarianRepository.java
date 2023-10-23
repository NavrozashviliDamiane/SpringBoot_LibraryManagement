package com.libmanagement.librarymanagementsystem.repository;

import com.libmanagement.librarymanagementsystem.entity.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LibrarianRepository extends JpaRepository<Librarian, Long> {

    Librarian findByUsername(String username);

    @Query("SELECT l FROM Librarian l WHERE l.username = ?1 AND l.password = ?2")
    Librarian findByUsernameAndPassword(String username, String password);
}
