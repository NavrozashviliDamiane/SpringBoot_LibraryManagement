package com.libmanagement.librarymanagementsystem.service;

import com.libmanagement.librarymanagementsystem.entity.Librarian;
import com.libmanagement.librarymanagementsystem.entity.Patron;
import com.libmanagement.librarymanagementsystem.entity.Role;
import com.libmanagement.librarymanagementsystem.repository.LibrarianRepository;
import com.libmanagement.librarymanagementsystem.repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    private final LibrarianRepository librarianRepository;
    private final PatronRepository patronRepository;

    @Autowired
    public UserServiceImpl(LibrarianRepository librarianRepository, PatronRepository patronRepository) {
        this.librarianRepository = librarianRepository;
        this.patronRepository = patronRepository;
    }

    @Override
    public Librarian registerLibrarian(Librarian librarian) {
        librarian.setRoles(Collections.singleton(Role.ADMIN));
        // Other creation logic
        return librarianRepository.save(librarian);
    }

    @Override
    public Patron registerPatron(Patron patron) {
        patron.setRoles(Collections.singleton(Role.USER));
        // Other creation logic
        return patronRepository.save(patron);
    }
}
