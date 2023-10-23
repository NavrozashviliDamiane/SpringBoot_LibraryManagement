package com.libmanagement.librarymanagementsystem.utility;

public class TransactionNotFoundException extends RuntimeException {

    public TransactionNotFoundException() {
        super();
    }

    public TransactionNotFoundException(String message) {
        super(message);
    }

    public TransactionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransactionNotFoundException(Throwable cause) {
        super(cause);
    }
}

