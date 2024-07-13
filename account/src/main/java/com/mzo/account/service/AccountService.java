package com.mzo.account.service;

import com.mzo.account.dto.AccountDto;
import com.mzo.account.model.FullAccountResponse;

import java.util.List;

public interface AccountService {

    void saveAccount(AccountDto accountDto);
    AccountDto findAccountById(String id);
    List<AccountDto> findAllAccounts();

    FullAccountResponse findFullAccountResponseById(String id);

    List<FullAccountResponse> findAllFullAccountsResponse();

    List<AccountDto> findAccountsByCustomerId(Long id);
}
