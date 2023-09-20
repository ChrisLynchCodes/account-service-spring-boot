package com.chris.accountservice.dao;

import com.chris.accountservice.models.Account;
import com.chris.accountservice.models.AccountInfoDto;

import java.util.List;
import java.util.Set;

public interface AccountDao extends DaoTemplate<Account> {


    int batchSave(Set<Account> accounts);

    int batchUpdate(Set<Account> accounts);

    int batchDelete(Set<Long> accountIdMap);

    List<AccountInfoDto> getAccountInfo();


}
