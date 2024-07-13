package com.mzo.customer.mapper;

import com.mzo.customer.dto.CustomerDto;
import com.mzo.customer.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    ModelMapper modelMapper = new ModelMapper();

    public Customer toCustomer(CustomerDto customerDto){
        return modelMapper.map(customerDto,Customer.class);
    }

    public CustomerDto fromCustomer(Customer customer){
        return modelMapper.map(customer,CustomerDto.class);
    }
}
