package com.mzo.customer.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class FullCustomerResponse {

    private String firstName;
    private String lastName;
    private String email;
    private List<Account> accounts;
}
