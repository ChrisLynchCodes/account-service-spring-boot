package com.chris.accountservice.dao;

import com.chris.accountservice.exceptions.AccountLogNotFoundException;
import com.chris.accountservice.models.AccountLog;

import java.util.List;
import java.util.Optional;

public interface AccountLogDao {
    List<AccountLog> get();

    Optional<AccountLog> findById(Long id);

    AccountLog save(AccountLog accountLog);

    AccountLog update(AccountLog accountLog) throws AccountLogNotFoundException;

    void delete(Long id) throws AccountLogNotFoundException;
}
