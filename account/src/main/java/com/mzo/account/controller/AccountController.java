package com.mzo.account.controller;

import com.mzo.account.dto.AccountDto;
import com.mzo.account.model.FullAccountResponse;
import com.mzo.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAccount(@RequestBody AccountDto accountDto){
        accountService.saveAccount(accountDto);
    }

    @GetMapping("/{account-id}")
    public ResponseEntity<AccountDto> findAccountById(@PathVariable("account-id") String id){
        return ResponseEntity.ok(accountService.findAccountById(id));
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> findAllAccounts(){
        return ResponseEntity.ok(accountService.findAllAccounts());
    }

    @GetMapping("/{account-id}/customer")
    public ResponseEntity<FullAccountResponse> findFullAccountResponseById(@PathVariable("account-id") String id){
        return ResponseEntity.ok(accountService.findFullAccountResponseById(id));
    }

    @GetMapping("/customers")
    public ResponseEntity<List<FullAccountResponse>> findAllFullAccountsResponse(){
        return ResponseEntity.ok(accountService.findAllFullAccountsResponse());
    }

    @GetMapping("/customer/{customer-id}")
    public ResponseEntity<List<AccountDto>> findAccountsByCustomerId(@PathVariable("customer-id") Long id){
        return ResponseEntity.ok(accountService.findAccountsByCustomerId(id));
    }
}
