package com.chris.accountservice.dao;

import com.chris.accountservice.exceptions.AccountNotFoundException;
import com.chris.accountservice.models.Account;

import java.util.Map;
import java.util.Optional;

public interface AccountDao {

    Map<String, Account> getAccounts();
    Optional<Account> findAccountById(Long id);
    Account save(Account account);
    Account update(Account account);
    void delete(Long id) throws AccountNotFoundException;
}
