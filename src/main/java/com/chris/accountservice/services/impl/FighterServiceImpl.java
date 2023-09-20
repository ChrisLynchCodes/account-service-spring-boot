package com.chris.accountservice.services.impl;

import com.chris.accountservice.dao.FighterDao;
import com.chris.accountservice.dtos.Fighter;
import com.chris.accountservice.services.FighterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class FighterServiceImpl implements FighterService {

    private FighterDao fighterDao;
    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    public FighterServiceImpl(FighterDao fighterDao) {
        this.fighterDao = fighterDao;
    }


    @Override
    public Set<Fighter> findAll() {
        List<Fighter> fighters = fighterDao.get();
        if (!fighters.isEmpty()) {
            return new HashSet<>(fighters);
        } else {
            return Collections.emptySet();
        }
    }

    @Override
    public Optional<Fighter> findById(Long id) {
        return id == null ? Optional.empty() : fighterDao.getById(id);
    }

    @Override
    @Transactional
    public Fighter save(@Valid Fighter fighter) {
        if (null != fighter) {
            Optional<Fighter> fighterDTOOptional = findByNameAndBirthDate(fighter.getFighterName(), fighter.getBirthDate());
            if (fighterDTOOptional.isPresent()) {
                fighter.setId(fighterDTOOptional.get().getId());
                fighter.setCreatedAt(fighterDTOOptional.get().getCreatedAt());
                fighter.setUpdatedAt(LocalDateTime.now());
                if (fighter.getProfileImageUrl().equals("")) {
                    fighter.setProfileImageUrl(fighterDTOOptional.get().getProfileImageUrl());
                }
                fighter = fighterDao.update(fighter);
                logger.info("Updated {}", fighter);
            } else {
                fighter.setCreatedAt(LocalDateTime.now());
                fighter.setUpdatedAt(fighter.getCreatedAt());
                fighter = fighterDao.save(fighter);
            }
        }
        return fighter;
    }


    @Override
    public Fighter update(Fighter fighter) {
        fighter = fighterDao.update(fighter);
        return fighter;
    }

    @Override
    public int delete(Long id) {
        if (id == null) {
            return 0;
        } else {
            return fighterDao.delete(id);
        }
    }

    @Override
    public Optional<Fighter> findByNameAndBirthDate(String fighterName, LocalDate birthDate) {
        return Optional.empty();
    }
}
