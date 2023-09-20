package com.chris.accountservice.dao.impl;

import com.chris.accountservice.dao.AccountDao;
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


    @Value("${spring.jpa.properties.hibernate.jdbc.batch_size:25}")
    private int batchSize;

    @Override
    public List<Account> get() {
        return entityManager.createQuery("SELECT a FROM Account a", Account.class).getResultList();
    }

    @Override
    public Optional<Account> getById(Long id) {
        return Optional.ofNullable(entityManager.find(Account.class, id));
    }

    @Override
    public Account save(Account account) throws IllegalArgumentException {
        if (null == account) {
            throw new IllegalArgumentException("account cannot be null");
        }
        entityManager.persist(account);
        entityManager.flush();
        return account;
    }

    @Override
    public Account update(Account account) throws IllegalArgumentException {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        return entityManager.merge(account);
    }


    @Override
    public int delete(Long id) throws IllegalArgumentException {
        if (null == id) {
            return 0;
        }
        Account account = entityManager.find(Account.class, id);
        if (account == null) {
            return 0;
        }
        entityManager.remove(account);
        return 1;

    }

    @Override
    @Transactional
    public int batchSave(Set<Account> accounts) {

        int persistedCount = 0;
        if (accounts != null) {
            Iterator<Account> iterator = accounts.iterator();
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
        }
        return persistedCount;
    }

    @Override
    public int batchUpdate(Set<Account> accounts) {
        return 0;
    }

    @Override
    public int batchDelete(Set<Long> accountIds) {
        return 0;
    }

    @Override
    public List<AccountInfoDto> getAccountInfo() {

        return entityManager.createNamedQuery(Account.ACCOUNT_INFO).getResultList();
    }


}
