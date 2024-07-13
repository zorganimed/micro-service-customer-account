package com.mzo.customer.controller;

import com.mzo.customer.dto.CustomerDto;
import com.mzo.customer.model.FullCustomerResponse;
import com.mzo.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCustomer(@RequestBody CustomerDto customerDto){
        customerService.saveCustomer(customerDto);
    }

    @GetMapping("/{customer-id}")
    public ResponseEntity<CustomerDto> findCustomerById(@PathVariable("customer-id") Long id){
        return ResponseEntity.ok(customerService.findCustomerById(id));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> findAllCustomers(){
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @GetMapping("/{customer-id}/accounts")
    public ResponseEntity<FullCustomerResponse> findAccountsByCustomerId(@PathVariable("customer-id") Long id){
        return ResponseEntity.ok(customerService.findAccountsByCustomerId(id));
    }
}
