package com.mzo.customer.service;

import com.mzo.customer.dto.CustomerDto;
import com.mzo.customer.model.FullCustomerResponse;

import java.util.List;

public interface CustomerService {

    void saveCustomer(CustomerDto customerDto);
    CustomerDto findCustomerById(Long id);
    List<CustomerDto> findAllCustomers();

    FullCustomerResponse findAccountsByCustomerId(Long id);
}
