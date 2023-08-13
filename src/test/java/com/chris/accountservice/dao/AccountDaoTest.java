package com.chris.accountservice.dao;

import com.chris.accountservice.enums.CurrencyCode;
import com.chris.accountservice.exceptions.AccountNotFoundException;
import com.chris.accountservice.models.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@ActiveProfiles("test")
public class AccountDaoTest {

    @Autowired
    private AccountDao accountDao;

    private Account testAccount;

    @Test
    void given10AccountsInDb_whenGetAccountsIsCalled_thenReturnAListOfAccounts() {
        List<Account> accounts = accountDao.getAccounts();
        Assert.isTrue(10 == accounts.size());
    }

    @Test
    void givenValidAccounts_whenBatchSaveIsCalled_thenReturnCountOfInserted() {
        Set<Account> accounts = new HashSet<>();
        Account account = new Account("test", "test", LocalDate.now(), CurrencyCode.AUD);
        Account accountb = new Account("test2", "test2", LocalDate.now(), CurrencyCode.EUR);
        accounts.add(account);
        accounts.add(accountb);

        int countAccountsInserted = accountDao.batchSave(accounts);

        Assert.isTrue(2 == countAccountsInserted);

    }

    @Test
    void givenAValidAccount_whenUpdateIsCalled_thenTheUpdatedEntityIsReturned() throws AccountNotFoundException {
        Account updates = new Account("test", "test", LocalDate.now(), CurrencyCode.AUD);
        updates.setId(1L);
        Account updated = accountDao.update(updates);
        Assert.notNull(updated);
        Assert.isTrue(updates.equals(updated));
    }

    @Test
    void givenANullValue_whenUpdateIsCalled_thenThrowException() throws AccountNotFoundException {

        //        Account updated = accountDao.update(null);

    }

}
