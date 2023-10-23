package com.libmanagement.librarymanagementsystem.utility;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}

