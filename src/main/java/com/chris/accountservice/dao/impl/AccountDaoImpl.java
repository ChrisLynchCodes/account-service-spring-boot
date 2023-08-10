package com.chris.accountservice.dao.impl;

import com.chris.accountservice.dao.AccountDao;
import com.chris.accountservice.exceptions.AccountNotFoundException;
import com.chris.accountservice.models.Account;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;

import java.util.Optional;

@Repository
@Transactional
public class AccountDaoImpl implements AccountDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Account> getAccounts() {

        List<Account> resultsList  = entityManager.createQuery("SELECT a FROM Account a", Account.class).getResultList();

        if(null != resultsList) {
            return resultsList;
        } else{
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<Account> findAccountById(Long id) throws AccountNotFoundException {
        return Optional.ofNullable(entityManager.find(Account.class, id));
    }

    @Override
    public Account save(Account account) {
        entityManager.persist(account);
        entityManager.flush();
        // TODO make sure this returning the account with Id
        return account;
    }

    @Override
    public Account update(Account account) throws AccountNotFoundException {
        Account updatedAccount = entityManager.merge(account);
        if(null != updatedAccount) {
            return updatedAccount;
        } else {
            throw new AccountNotFoundException(account.getId());
        }
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
}
