package com.chris.accountservice.dao;

import com.chris.accountservice.exceptions.AccountNotFoundException;
import com.chris.accountservice.models.Account;
import com.chris.accountservice.models.AccountInfoDto;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AccountDao {

    List<Account> getAccounts();

    Optional<Account> findById(Long id);

    Account save(Account account) throws IllegalArgumentException;

    Account update(Account account) throws IllegalArgumentException;
    void delete(Long id) throws AccountNotFoundException;

    int batchSave(Set<Account> accounts);

    int batchUpdate(Set<Account> accounts);

    int batchDelete(Set<Long> accountIdMap);

    List<AccountInfoDto> getAccountInfo();
}
