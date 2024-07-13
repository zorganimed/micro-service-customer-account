package com.mzo.account.service;

import com.mzo.account.client.CustomerClient;
import com.mzo.account.dto.AccountDto;
import com.mzo.account.entity.Account;
import com.mzo.account.enums.AccountStatus;
import com.mzo.account.enums.AccountType;
import com.mzo.account.mapper.AccountMapper;
import com.mzo.account.model.FullAccountResponse;
import com.mzo.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final CustomerClient customerClient;

    @Override
    public void saveAccount(AccountDto accountDto) {
        var account = accountMapper.toAccount(accountDto);
        accountRepository.save(account);
    }

    @Override
    public AccountDto findAccountById(String id) {
        var account = accountRepository.findById(id).orElse(Account.builder().id(id).balance(0)
                .creationDate(LocalDate.now()).currency("NOT_FOUND").accountStatus(AccountStatus.NOT_FOUND)
                .accountType(AccountType.NOT_FOUND).build());
        var accountDto = accountMapper.fromAccount(account);
        return accountDto;
    }

    @Override
    public List<AccountDto> findAllAccounts() {
        var accounts = accountRepository.findAll();
        var accountDtos = accounts.stream().map(a->accountMapper.fromAccount(a)).toList();
        return accountDtos;
    }

    @Override
    public FullAccountResponse findFullAccountResponseById(String id) {
        var account = accountRepository.findById(id).orElse(Account.builder().id(id).balance(0)
                .creationDate(LocalDate.now()).currency("NOT_FOUND").accountStatus(AccountStatus.NOT_FOUND)
                .accountType(AccountType.NOT_FOUND).build());
        var customer = customerClient.findCustomerById(account.getCustomerId());
        return FullAccountResponse.builder().id(id).balance(account.getBalance())
                .currency(account.getCurrency()).accountStatus(account.getAccountStatus())
                .accountType(account.getAccountType()).creationDate(account.getCreationDate())
                .customer(customer).build();
    }

    @Override
    public List<FullAccountResponse> findAllFullAccountsResponse() {
        var accounts = accountRepository.findAll();
        var fullAccountsResponse = accounts.stream().
                map(a->findFullAccountResponseById(a.getId())).toList();
        return fullAccountsResponse;
    }

    @Override
    public List<AccountDto> findAccountsByCustomerId(Long id) {
        var accounts = accountRepository.findByCustomerId(id);
        return accounts.stream().map(a->accountMapper.fromAccount(a)).toList();
    }
}
