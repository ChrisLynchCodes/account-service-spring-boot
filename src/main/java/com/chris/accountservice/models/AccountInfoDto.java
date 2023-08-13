package com.chris.accountservice.models;

import com.chris.accountservice.enums.CurrencyCode;

public class AccountInfoDto {
    private String foreName;
    private CurrencyCode currencyCode;
    private String operationType;

    public AccountInfoDto(String foreName, CurrencyCode currencyCode, String operationType) {
        this.foreName = foreName;
        this.currencyCode = currencyCode;
        this.operationType = operationType;
    }

    public String getForeName() {
        return foreName;
    }

    public void setForeName(String foreName) {
        this.foreName = foreName;
    }

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
}
