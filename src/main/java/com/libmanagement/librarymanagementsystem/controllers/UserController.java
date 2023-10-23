package com.libmanagement.librarymanagementsystem.controllers;


import com.libmanagement.librarymanagementsystem.entity.Librarian;
import com.libmanagement.librarymanagementsystem.entity.Patron;
import com.libmanagement.librarymanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user") // Define a base URL for user-related operations
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register/librarian")
    public Librarian registerLibrarian(@RequestBody Librarian librarian) {
        return userService.registerLibrarian(librarian);
    }

    @PostMapping("/register/patron")
    public Patron registerPatron(@RequestBody Patron patron) {
        return userService.registerPatron(patron);
    }
}
