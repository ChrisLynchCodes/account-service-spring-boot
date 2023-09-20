package com.chris.accountservice.dao.impl;

import com.chris.accountservice.dao.FighterDao;
import com.chris.accountservice.dtos.Fighter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
@Transactional
public class FighterDaoImpl implements FighterDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List get() {
        return entityManager.createQuery("SELECT f FROM Fighter f", Fighter.class).getResultList();
    }

    @Override
    public Optional getById(Long id) {
        return Optional.ofNullable(entityManager.find(Fighter.class, id));
    }

    @Override
    public Fighter save(Fighter fighter) throws IllegalArgumentException {
        if (null == fighter) {
            throw new IllegalArgumentException("Fighter cannot be null");
        }
        entityManager.persist(fighter);
        entityManager.flush();
        return fighter;
    }

    @Override
    public Fighter update(Fighter fighter) {
        if (fighter == null) {
            throw new IllegalArgumentException("fighterDTO cannot be null");
        }
        return entityManager.merge(fighter);
    }

    @Override
    public int delete(Long id) {
        // TODO this code needs cleaned up very hacky!
        if (null == id) {
            return 0;
        }
        Fighter fighter = entityManager.find(Fighter.class, id);
        if (null == fighter) {
            return 0;
        }
        entityManager.remove(fighter);
        return 1;
    }

    @Override
    public int batchSave(Set<Fighter> fighters) {
        return 0;
    }

    @Override
    public int batchUpdate(Set<Fighter> fighters) {
        return 0;
    }

    @Override
    public int batchDelete(Set<Long> fighterIdMap) {
        return 0;
    }

    @Override
    public Optional<Fighter> findByNameAndBirthDate(String fighterName, LocalDate birthDate) {
        TypedQuery<Fighter> query = entityManager.createQuery(
                "SELECT f FROM Fighter f WHERE f.fighterName = :fighterName AND f.birthDate = :birthDate",
                Fighter.class
        );
        query.setParameter("fighterName", fighterName);
        query.setParameter("birthDate", birthDate);
        try {
            Optional<Fighter> optionalAccount = Optional.ofNullable(query.getSingleResult());
            return optionalAccount;
        } catch (NoResultException ex) {
            return Optional.empty();

        }
    }
}
