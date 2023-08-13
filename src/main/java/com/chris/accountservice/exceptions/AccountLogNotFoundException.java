package com.chris.accountservice.exceptions;

public class AccountLogNotFoundException extends Exception {
    public AccountLogNotFoundException(Long id) {
        System.out.println("Account Log Not Found Id: " + id);
    }
}
