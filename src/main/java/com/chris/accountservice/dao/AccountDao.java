package com.chris.accountservice.dao;

import com.chris.accountservice.exceptions.AccountNotFoundException;
import com.chris.accountservice.models.Account;

import java.util.List;
import java.util.Optional;

public interface AccountDao {

    List<Account> getAccounts();
    Optional<Account> findAccountById(Long id) throws AccountNotFoundException;
    Account save(Account account);
    Account update(Account account) throws AccountNotFoundException;
    void delete(Long id) throws AccountNotFoundException;
}
