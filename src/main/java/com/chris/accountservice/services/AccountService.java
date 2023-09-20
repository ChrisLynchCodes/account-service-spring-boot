package com.chris.accountservice.services;

import com.chris.accountservice.models.Account;
import com.chris.accountservice.models.AccountInfoDto;

import java.util.Set;

public interface AccountService extends ServiceTemplate<Account> {

    Set<AccountInfoDto> findAllAccountInfo();

}
