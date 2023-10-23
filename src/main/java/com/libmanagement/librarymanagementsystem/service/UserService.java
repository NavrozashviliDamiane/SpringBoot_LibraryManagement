package com.libmanagement.librarymanagementsystem.service;

import com.libmanagement.librarymanagementsystem.entity.Librarian;
import com.libmanagement.librarymanagementsystem.entity.Patron;

public interface UserService {
    Librarian registerLibrarian(Librarian librarian);
    Patron registerPatron(Patron patron);
}