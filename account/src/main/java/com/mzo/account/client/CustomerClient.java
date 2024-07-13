package com.mzo.account.client;

import com.mzo.account.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER", url = "${application.config.customer-url}")
public interface CustomerClient {

    @GetMapping("/{customer-id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable("customer-id") Long id);

    default Customer getDefaultCustomer(Long id, Exception e){
        return Customer.builder()
                .firstName("NOT_FOUND").lastName("NOT_FOUND").email("NOT_FOUND").build();
    }
}
