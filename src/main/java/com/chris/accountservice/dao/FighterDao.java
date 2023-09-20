package com.chris.accountservice.dao;

import com.chris.accountservice.dtos.Fighter;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

public interface FighterDao extends DaoTemplate<Fighter> {

    int batchSave(Set<Fighter> fighters);

    int batchUpdate(Set<Fighter> fighters);

    int batchDelete(Set<Long> fighterIdMap);


    Optional<Fighter> findByNameAndBirthDate(String fighterName, LocalDate birthDate);
}
