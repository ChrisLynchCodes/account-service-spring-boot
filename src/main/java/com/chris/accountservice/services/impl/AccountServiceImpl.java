package com.chris.accountservice.services.impl;

import com.chris.accountservice.dao.AccountDao;
import com.chris.accountservice.dao.AccountLogDao;
import com.chris.accountservice.models.Account;
import com.chris.accountservice.models.AccountInfoDto;
import com.chris.accountservice.services.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.*;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    @Autowired
    private AccountLogDao accountLogDao;
    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);


    @Override
    public Set<Account> findAll() {
        List<Account> accounts = accountDao.get();
        if (!accounts.isEmpty()) {
            return new HashSet<>(accounts);
        } else {
            return Collections.emptySet();
        }
    }


    @Override
    public Optional<Account> findById(Long id) {
        return id == null ? Optional.empty() : accountDao.getById(id);
    }

    @Override
    @Transactional
    public Account save(@Valid Account account) {
        if (null != account) {
            account = accountDao.save(account);
        }

//
//        AccountLog accountLog = new AccountLog();
//        accountLog.setOperationType("Create new account");
//        accountLog.setTimestamp(LocalDateTime.now());
//        accountLog.setAccount(account);
//        accountLogDao.save(accountLog);
        return account;
    }

    @Override
    public Account update(@Valid Account account) {
        account = accountDao.update(account);
        return account;

    }

    @Override
    public int delete(Long id) {
        if (null == id) {
            return 0;
        }
        return accountDao.delete(id);
    }

    @Override
    public Set<AccountInfoDto> findAllAccountInfo() {
        // TODO error handling, null checking, exceptions etc needed
        List<AccountInfoDto> accountInfoDtos = accountDao.getAccountInfo();

        return Set.copyOf(accountInfoDtos);
    }


}
