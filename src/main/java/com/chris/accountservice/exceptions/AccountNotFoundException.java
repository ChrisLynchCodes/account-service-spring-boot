package com.chris.accountservice.exceptions;

public class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        System.out.println("Account Not Found: " + message);
    }
}
