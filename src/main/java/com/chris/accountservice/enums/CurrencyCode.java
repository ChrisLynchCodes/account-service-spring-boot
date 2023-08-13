package com.chris.accountservice.enums;

public enum CurrencyCode {
    USD("United States Dollar"),
    EUR("Euro"),
    GBP("British Pound"),
    JPY("Japanese Yen"),
    AUD("Australian Dollar"),
    CAD("Canadian Dollar"),
    CHF("Swiss Franc"),
    INR("Indian Rupee "),
    SGD("Singapore Dollar"),
    HKD("Hong Kong Dollar");

    // TODO Add more currency codes here...

    // Constructor to associate a description with each currency
    private final String description;

    CurrencyCode(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    public String getCode() {
        return name(); // Returns the enum constant name (e.g., "USD", "EUR")
    }
    }

