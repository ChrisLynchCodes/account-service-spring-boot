package com.chris.accountservice.exceptions;

public class AccountNotFoundException extends Exception {
    public AccountNotFoundException(Long id) {
        System.out.println("Account Not Found Id: " + id);
    }
}
