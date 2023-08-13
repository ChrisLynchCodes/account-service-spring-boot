package com.chris.accountservice.services;

import com.chris.accountservice.exceptions.AccountNotFoundException;
import com.chris.accountservice.models.Account;
import com.chris.accountservice.models.AccountInfoDto;

import java.util.Optional;
import java.util.Set;

public interface AccountService {
    Set<Account> findAll();

    Optional<Account> findById(Long id) throws AccountNotFoundException;

    Account save(Account account);

    Account update(Account account) throws AccountNotFoundException;

    void delete(Long id) throws AccountNotFoundException;

    Set<AccountInfoDto> findAllAccountInfo();
}
