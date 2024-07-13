package com.mzo.customer.model;

import com.mzo.customer.enums.AccountStatus;
import com.mzo.customer.enums.AccountType;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Account {

    private String id;
    private String currency;
    private double balance;
    private LocalDate creationDate;
    private AccountStatus accountStatus;
    private AccountType accountType;
}
