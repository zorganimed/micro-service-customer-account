package com.mzo.customer.client;

import com.mzo.customer.model.Account;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ACCOUNT", url = "${application.config.account-url}")
public interface AccountClient {

    @GetMapping("/customer/{customer-id}")
    @CircuitBreaker(name = "accountService", fallbackMethod = "getDefaultAccounts")
    List<Account> findAccountsByCustomerId(@PathVariable("customer-id") Long id);

    default List<Account>  getDefaultAccounts(Long id){
        return List.of();
    }
}
