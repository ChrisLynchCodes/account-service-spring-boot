package com.chris.accountservice.services.impl;

import com.chris.accountservice.dao.AccountLogDao;
import com.chris.accountservice.models.AccountLog;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class AccountLogServiceImpl implements com.chris.accountservice.services.AccountLogService {

    @Autowired
    private AccountLogDao accountLogDao;

    @Override
    public Map<String, AccountLog> findAll() {
        List<AccountLog> accountLogs = accountLogDao.get();
        return accountLogs.stream()
                .collect(Collectors.toMap(account -> account.getId().toString(), account -> account));
    }

    @Override
    public Optional<AccountLog> findById(Long id) {
        return id == null ? Optional.empty() : accountLogDao.findById(id);
    }

    @Override
    public AccountLog save(AccountLog account) {
        return null;

    }

    @Override
    public AccountLog update(AccountLog account) {
        return null;
    }

    @Override
    public void delete(AccountLog id) {

    }
}
