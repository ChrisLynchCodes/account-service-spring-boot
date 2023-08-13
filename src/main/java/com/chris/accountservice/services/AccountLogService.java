package com.chris.accountservice.services;

import com.chris.accountservice.models.AccountLog;

import java.util.Map;
import java.util.Optional;

public interface AccountLogService {
    Map<String, AccountLog> findAll();

    Optional<AccountLog> findById(Long id);

    AccountLog save(AccountLog account);

    AccountLog update(AccountLog account);

    void delete(AccountLog id);
}
