package com.libmanagement.librarymanagementsystem.utility;

public class PatronNotFoundException extends RuntimeException {
    public PatronNotFoundException(String message) {
        super(message);
    }
}
