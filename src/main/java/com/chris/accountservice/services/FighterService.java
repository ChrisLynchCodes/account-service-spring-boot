package com.chris.accountservice.services;

import com.chris.accountservice.dtos.Fighter;

import java.time.LocalDate;
import java.util.Optional;

public interface FighterService extends ServiceTemplate<Fighter> {

    Optional<Fighter> findByNameAndBirthDate(String fighterName, LocalDate birthDate);
}
