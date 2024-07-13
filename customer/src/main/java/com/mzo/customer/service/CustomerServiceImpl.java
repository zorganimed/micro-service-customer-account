package com.mzo.customer.service;

import com.mzo.customer.client.AccountClient;
import com.mzo.customer.dto.CustomerDto;
import com.mzo.customer.entity.Customer;
import com.mzo.customer.mapper.CustomerMapper;
import com.mzo.customer.model.FullCustomerResponse;
import com.mzo.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final AccountClient accountClient;

    @Override
    public void saveCustomer(CustomerDto customerDto) {
        var customer = customerMapper.toCustomer(customerDto);
        customerRepository.save(customer);
    }

    @Override
    public CustomerDto findCustomerById(Long id) {
        var customer = customerRepository.findById(id).orElse(Customer.builder().id(id)
                .firstName("NOT_FOUND").lastName("NOT_FOUND").email("NOT_FOUND").build());
        var customerDto = customerMapper.fromCustomer(customer);
        return customerDto;
    }

    @Override
    public List<CustomerDto> findAllCustomers() {
        var customers = customerRepository.findAll();
        var accountDtos = customers.stream().map(c->customerMapper.fromCustomer(c)).toList();
        return accountDtos;
    }

    @Override
    public FullCustomerResponse findAccountsByCustomerId(Long id) {
        var customer = customerRepository.findById(id).orElse(Customer.builder().id(id)
                .firstName("NOT_FOUND").lastName("NOT_FOUND").email("NOT_FOUND").build());
        var accounts = accountClient.findAccountsByCustomerId(customer.getId());

        return FullCustomerResponse.builder().firstName(customer.getFirstName())
                .lastName(customer.getLastName()).email(customer.getEmail())
                .accounts(accounts).build();
    }
}
