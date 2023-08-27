package com.chris.accountservice.controllers;

import com.chris.accountservice.exceptions.AccountNotFoundException;
import com.chris.accountservice.models.Account;
import com.chris.accountservice.models.AccountInfoDto;
import com.chris.accountservice.services.AccountService;
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
@RequestMapping("/api/v1/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);


    @GetMapping()
    public ResponseEntity<Set<Account>> getAccounts(HttpServletRequest request) {
        Set<Account> accounts = accountService.findAll();
        logger.info("Returned {} accounts", accounts.size());
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/info/account-info")
    public ResponseEntity<Set<AccountInfoDto>> getAccountInfo() {
        logger.info("Getting account info using DTO");
        Set<AccountInfoDto> accountInfo = accountService.findAllAccountInfo();
        return ResponseEntity.ok(accountInfo);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long accountId) throws AccountNotFoundException {
        logger.info("Getting account with id: {}", accountId);
        Optional<Account> optionalAccount = accountService.findById(accountId);
        if (optionalAccount.isPresent())
            logger.info("Got account with id: {} ", optionalAccount.get().getId());
        return optionalAccount.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createAccount(@Valid @RequestBody Account account) {
        accountService.save(account);
        logger.info("Account created successfully: {}", account);
        return ResponseEntity.status(HttpStatus.CREATED).body("Account created successfully " + account);
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long accountId, @Valid @RequestBody Account updatedAccount) throws AccountNotFoundException {

        Optional<Account> accountOptional = accountService.findById(accountId);

        if (accountOptional.isPresent()) {
            logger.info("Updating account {}", accountOptional.get());
            Account account = accountOptional.get();
            account.setForeName(updatedAccount.getForeName());
            account.setSurName(updatedAccount.getSurName());
            account.setBirthDate(updatedAccount.getBirthDate());
            account.setAccountLogs(updatedAccount.getAccountLogs());
            account.setCurrencyCode(updatedAccount.getCurrencyCode());

            accountService.update(account);
            logger.info("Account updated successfully: {}", account);
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.notFound().build();
        }

    }


    @DeleteMapping("/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long accountId) {
        try {
            logger.info("Deleting account with id: {}", accountId);
            accountService.delete(accountId);
            return ResponseEntity.ok("Account deleted successfully");
        } catch (AccountNotFoundException e) {
            logger.error("Account not found", e);
            return ResponseEntity.notFound().build();
        }
    }

    // TODO Batch insert and delete endpoints


}
