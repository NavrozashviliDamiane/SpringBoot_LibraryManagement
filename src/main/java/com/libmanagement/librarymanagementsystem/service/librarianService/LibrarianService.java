package com.libmanagement.librarymanagementsystem.service.librarianService;

import com.libmanagement.librarymanagementsystem.entity.Librarian;

import java.util.List;

public interface LibrarianService {
    Librarian getLibrarianByUsername(String username);
    Librarian getLibrarianByUsernameAndPassword(String username, String password);
    List<Librarian> getAllLibrarians();
    Librarian createLibrarian(Librarian librarian);
    Librarian updateLibrarian(Long id, Librarian librarian);
    void deleteLibrarian(Long id);
}
