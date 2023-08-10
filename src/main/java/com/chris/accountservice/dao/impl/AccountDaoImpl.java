package com.chris.accountservice.dao.impl;

import com.chris.accountservice.dao.AccountDao;
import com.chris.accountservice.exceptions.AccountNotFoundException;
import com.chris.accountservice.models.Account;

import java.util.Map;
import java.util.Optional;

public class AccountDaoImpl implements AccountDao {
    @Override
    public Map<String, Account> getAccounts() {
        return null;
    }

    @Override
    public Optional<Account> findAccountById(Long id) {
        return Optional.empty();
    }

    @Override
    public Account save(Account account) {
        return null;
    }

    @Override
    public Account update(Account account) {
        return null;
    }

    @Override
    public void delete(Long id) throws AccountNotFoundException {

    }
}
