package com.chris.accountservice.dao.impl;

import com.chris.accountservice.dao.AccountLogDao;
import com.chris.accountservice.exceptions.AccountLogNotFoundException;
import com.chris.accountservice.models.AccountLog;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
@Transactional
public class AccountLogDaoImpl implements AccountLogDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<AccountLog> get() {

        List<AccountLog> resultsList = entityManager.createQuery("SELECT a FROM ACCOUNT_LOG a", AccountLog.class).getResultList();

        return Objects.requireNonNullElse(resultsList, Collections.emptyList());
    }

    @Override
    public Optional<AccountLog> findById(Long id) {
        return Optional.ofNullable(entityManager.find(AccountLog.class, id));
    }

    @Override
    public AccountLog save(AccountLog accountLog) {
        entityManager.persist(accountLog);
        entityManager.flush();
        // TODO make sure this returning the accessLog with Id
        return accountLog;
    }

    @Override
    public AccountLog update(AccountLog accountLog) throws AccountLogNotFoundException {
        AccountLog updatedAccountLog = entityManager.merge(accountLog);
        if (null != updatedAccountLog) {
            return updatedAccountLog;
        } else {
            throw new AccountLogNotFoundException(accountLog.getId());
        }
    }

    @Override
    public void delete(Long id) throws AccountLogNotFoundException {
        AccountLog accountLog = entityManager.find(AccountLog.class, id);
        if (accountLog != null) {
            entityManager.remove(accountLog);
        } else {
            throw new AccountLogNotFoundException(id);
        }

    }
}
