package com.chris.accountservice.dao;

import com.chris.accountservice.models.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class AccountDaoTest {

    @Autowired
    private AccountDao accountDao;
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void given10AccountsInDb_whenGetAccountsIsCalled_thenReturnAListOfAccounts() {
        List<Account> accounts = accountDao.get();
        assertThat(accounts).hasSize(10);
    }
//    @Test
//    void givenValidAccounts_whenBatchSaveIsCalled_thenReturnCountOfInserted() {
//        Set<Account> accounts = new HashSet<>();
//        Account account = new Account("test", "test", LocalDate.now(), CurrencyCode.AUD);
//        Account accountb = new Account("test2", "test2", LocalDate.now(), CurrencyCode.EUR);
//        accounts.add(account);
//        accounts.add(accountb);
//
//        int countAccountsInserted = accountDao.batchSave(accounts);
//
//        Assert.isTrue(2 == countAccountsInserted);
//
//    }
//
//    @Test
//    void givenAnEmptyCollection_whenBatchSaveIsCalled_thenReturnZero() {
//        int savedCount = accountDao.batchSave((Collections.EMPTY_SET));
//        assertThat(savedCount).isZero();
//
//    }
//
//    @Test
//    void givenANullValue_whenBatchSaveIsCalled_thenReturnZero() {
//        int savedCount = accountDao.batchSave((null));
//        assertThat(savedCount).isZero();
//    }
//
//
//    @Test
//    void givenAValidAccount_whenUpdateIsCalled_thenTheUpdatedEntityIsReturned() {
//        Account updates = new Account("test", "test", LocalDate.now(), CurrencyCode.AUD);
//        updates.setId(1L);
//        Account updated = accountDao.update(updates);
//        assertThat(updated).isNotNull();
//        assertThat(updates).isEqualTo(updated);
//    }
//
//    @Test
//    void givenANullValue_whenUpdateIsCalled_thenThrowException() {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> accountDao.update(null));
//    }
//
//    @Test
//    void givenAnEntityNotInDb_whenUpdateIsCalled_thenPersistAndReturn() {
//        Account updates = new Account("test", "test", LocalDate.now(), CurrencyCode.AUD);
//        updates.setId(12345L);
//        Account updated = accountDao.update(updates);
//        assertThat(updated).isNotNull();
//        assertThat(updates.getForeName()).isEqualTo(updated.getForeName());
//        assertThat(updates.getSurName()).isEqualTo(updated.getSurName());
//        assertThat(updates.getBirthDate()).isEqualTo(updated.getBirthDate());
//        assertThat(updates.getCurrencyCode()).isEqualTo(updated.getCurrencyCode());
//    }
//
//    @Test
//    void givenAValidId_whenDeleteIsCalled_thenEntityIsRemoved() throws AccountNotFoundException {
//        Long id = 1L;
//        accountDao.delete(id);
//        assertThat(entityManager.find(Account.class, id)).isNull();
//    }
//
//    @Test
//    void givenANullValue_whenDeleteIsCalled_thenThrowIllegalArgumentException() throws IllegalArgumentException {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> accountDao.delete(null));
//    }
//
//    @Test
//    void givenAnIdNotInDb_whenDeleteIsCalled_thenThrowAccountNotFoundException() {
//        Assertions.assertThrows(AccountNotFoundException.class, () -> accountDao.delete(123L));
//    }
//
//    @Test
//    void whenGetAccountInfoIsCalled() {
//
//    }
//
//    @Test
//    void whenGetBatchDeleteIsCalled() {
//
//    }
//
//    @Test
//    void whenGetBatchUpdateIsCalled() {
//        // TODO can this replace batch insert with this - go back and do with tutorial to replace in endpoints etc
//
//    }

}
