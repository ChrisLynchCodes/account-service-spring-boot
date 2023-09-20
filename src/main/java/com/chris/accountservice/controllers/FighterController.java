package com.chris.accountservice.controllers;

import com.chris.accountservice.dtos.Fighter;
import com.chris.accountservice.services.FighterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/fighter")
public class FighterController {

    private FighterService fighterService;

    @Autowired
    public FighterController(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    private static final Logger logger = LoggerFactory.getLogger(FighterController.class);


    @GetMapping()
    public ResponseEntity<Set<Fighter>> getFighters(HttpServletRequest request) {
        logger.info("getFighters request received: {}", request.getRequestURL());
        Set<Fighter> fighters = fighterService.findAll();
        logger.info("{} Fighters returned", fighters.size());
        return ResponseEntity.ok(fighters);
    }


    @GetMapping("/{fighterId}")
    public ResponseEntity<Fighter> getFighterById(@PathVariable Long fighterId) {
        logger.info("Getting fighter with id: {}", fighterId);
        Optional<Fighter> optionalFighter = fighterService.findById(fighterId);

        return optionalFighter.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Fighter> createFighter(@Valid @RequestBody Fighter fighter) {
        // TODO map a fighter dto to a fighter model in service layer
        fighterService.save(fighter);

        return ResponseEntity.status(HttpStatus.CREATED).body(fighter);
    }

    @PutMapping("/{fighterId}")
    public ResponseEntity<Fighter> updateFighter(@PathVariable Long fighterId, @Valid @RequestBody Fighter updatedAFighter) {

        // TODO get the updated fughter from the Request body
        Optional<Fighter> fighterOptional = fighterService.findById(fighterId);

        if (fighterOptional.isPresent()) {
            logger.info("Updating fighter {}", fighterOptional.get());
            Fighter fighter = fighterOptional.get();
            fighterService.update(fighter);
            logger.info("Fighter updated successfully: {}", fighter);

            return ResponseEntity.ok(fighter);
        } else {
            return ResponseEntity.notFound().build();
        }

    }


    @DeleteMapping("/{fighterId}")
    public ResponseEntity<Integer> deleteFighter(@PathVariable Long fighterId) {
        try {
            logger.info("Deleting fighter with id: {}", fighterId);
            Integer deleteCount = fighterService.delete(fighterId);
            return ResponseEntity.ok(deleteCount);
        } catch (Exception e) {
            // TODO catch correct type of execption
            logger.error("Fighter not found", e);
            return ResponseEntity.notFound().build();
        }
    }

    // TODO Batch insert and delete endpoints
}
