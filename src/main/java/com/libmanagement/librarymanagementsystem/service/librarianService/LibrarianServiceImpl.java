package com.libmanagement.librarymanagementsystem.service.librarianService;

import com.libmanagement.librarymanagementsystem.entity.Librarian;
import com.libmanagement.librarymanagementsystem.repository.LibrarianRepository;
import com.libmanagement.librarymanagementsystem.service.librarianService.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrarianServiceImpl implements LibrarianService {

    private final LibrarianRepository librarianRepository;

    @Autowired
    public LibrarianServiceImpl(LibrarianRepository librarianRepository) {
        this.librarianRepository = librarianRepository;
    }

    @Override
    public Librarian getLibrarianByUsername(String username) {
        return librarianRepository.findByUsername(username);
    }

    @Override
    public Librarian getLibrarianByUsernameAndPassword(String username, String password) {
        return librarianRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public List<Librarian> getAllLibrarians() {
        return librarianRepository.findAll();
    }

    @Override
    public Librarian createLibrarian(Librarian librarian) {
        return librarianRepository.save(librarian);
    }

    @Override
    public Librarian updateLibrarian(Long id, Librarian librarian) {
        if (librarianRepository.existsById(id)) {
            librarian.setId(id);
            return librarianRepository.save(librarian);
        } else {
            // Handle the case where the librarian with the given ID does not exist
            return null;
        }
    }

    @Override
    public void deleteLibrarian(Long id) {
        librarianRepository.deleteById(id);
    }
}
