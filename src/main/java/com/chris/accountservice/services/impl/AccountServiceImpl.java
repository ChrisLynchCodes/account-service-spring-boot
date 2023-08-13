package com.chris.accountservice.services.impl;

import com.chris.accountservice.dao.AccountDao;
import com.chris.accountservice.dao.AccountLogDao;
import com.chris.accountservice.exceptions.AccountNotFoundException;
import com.chris.accountservice.models.Account;
import com.chris.accountservice.models.AccountInfoDto;
import com.chris.accountservice.models.AccountLog;
import com.chris.accountservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.*;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    @Autowired
    private AccountLogDao accountLogDao;

    @Override
    public Set<Account> findAll() {
        List<Account> accounts = accountDao.getAccounts();
        if (!accounts.isEmpty()) {
            return new HashSet<>(accounts);
        } else {
            return Collections.EMPTY_SET;
        }
    }


    @Override
    public Optional<Account> findById(Long id) {

        return id == null ? Optional.empty() : accountDao.findById(id);
    }

    @Override
    @Transactional
    public Account save(Account account) {
        account = accountDao.save(account);

        AccountLog accountLog = new AccountLog();
        accountLog.setOperationType("Create new account");
        accountLog.setTimestamp(LocalDateTime.now());
        accountLog.setAccount(account);
        accountLogDao.save(accountLog);
        return account;
    }

    @Override
    public Account update(@Valid Account account) throws AccountNotFoundException {
        account = accountDao.update(account);
        return account;

    }

    @Override
    public void delete(Long id) throws AccountNotFoundException {
        accountDao.delete(id);

    }

    @Override
    public Set<AccountInfoDto> findAllAccountInfo() {
        // TODO error handling, null checking, exceptions etc needed
        List<AccountInfoDto> accountInfoDtos = accountDao.getAccountInfo();

        return Set.copyOf(accountInfoDtos);
    }
}