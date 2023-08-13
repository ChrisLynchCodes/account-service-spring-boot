package com.chris.accountservice.dao.impl;

import com.chris.accountservice.dao.AccountDao;
import com.chris.accountservice.exceptions.AccountNotFoundException;
import com.chris.accountservice.models.Account;
import com.chris.accountservice.models.AccountInfoDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Repository
@Transactional
public class AccountDaoImpl implements AccountDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
    private final int batchSize = 25;
    @Override
    public List<Account> getAccounts() {
        return entityManager.createQuery("SELECT a FROM Account a", Account.class).getResultList();
    }

    @Override
    public Optional<Account> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Account.class, id));
    }

    @Override
    public Account save(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        entityManager.persist(account);
        entityManager.flush();
        return account;
    }

    @Override
    public Account update(Account account) throws AccountNotFoundException {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        return entityManager.merge(account);
    }

    @Override
    public void delete(Long id) throws AccountNotFoundException {
        Account account = entityManager.find(Account.class, id);
        if (account != null) {
            entityManager.remove(account);
        } else {
            throw new AccountNotFoundException(id);
        }

    }

    @Override
    @Transactional
    public int batchSave(Set<Account> accounts) {
        Iterator<Account> iterator = accounts.iterator();
        int persistedCount = 0;

        while (iterator.hasNext()) {
            Set<Account> batch = new HashSet<>();
            for (int i = 0; i < batchSize && iterator.hasNext(); i++) {
                batch.add(iterator.next());
            }
            for (Account account : batch) {
                entityManager.persist(account);
            }
            persistedCount += batch.size();
            entityManager.flush();
            entityManager.clear();

        }
        return persistedCount;
    }

    @Override
    public int batchDelete(Set<Long> accountIds) {
        return 0;
    }

    @Override
    public List<AccountInfoDto> getAccountInfo() {

        return (List<AccountInfoDto>) entityManager.createNamedQuery(Account.ACCOUNT_INFO).getResultList();
    }

}
