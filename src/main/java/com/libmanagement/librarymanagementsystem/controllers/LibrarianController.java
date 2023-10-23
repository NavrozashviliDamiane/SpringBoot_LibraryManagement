package com.libmanagement.librarymanagementsystem.controllers;

import com.libmanagement.librarymanagementsystem.entity.Librarian;
import com.libmanagement.librarymanagementsystem.service.librarianService.LibrarianServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/librarians")
public class LibrarianController {

    private final LibrarianServiceImpl librarianService;

    @Autowired
    public LibrarianController(LibrarianServiceImpl librarianService) {
        this.librarianService = librarianService;
    }



    @GetMapping("/username/{username}")
    public ResponseEntity<Librarian> getLibrarianByUsername(@PathVariable String username) {
        Librarian librarian = librarianService.getLibrarianByUsername(username);
        if (librarian != null) {
            return ResponseEntity.ok(librarian);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/login")
    public ResponseEntity<Librarian> getLibrarianByUsernameAndPassword(
            @RequestParam String username,
            @RequestParam String password
    ) {
        Librarian librarian = librarianService.getLibrarianByUsernameAndPassword(username, password);
        if (librarian != null) {
            return ResponseEntity.ok(librarian);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/all")
    public List<Librarian> getAllLibrarians() {
        return librarianService.getAllLibrarians();
    }

    @PostMapping("/create")
    public ResponseEntity<Librarian> createLibrarian(@RequestBody Librarian librarian) {
        Librarian createdLibrarian = librarianService.createLibrarian(librarian);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLibrarian);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Librarian> updateLibrarian(
            @PathVariable Long id,
            @RequestBody Librarian librarian
    ) {
        Librarian updatedLibrarian = librarianService.updateLibrarian(id, librarian);
        if (updatedLibrarian != null) {
            return ResponseEntity.ok(updatedLibrarian);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibrarian(@PathVariable Long id) {
        librarianService.deleteLibrarian(id);
        return ResponseEntity.noContent().build();
    }
}
