package com.mzo.account.dto;

import com.mzo.account.enums.AccountStatus;
import com.mzo.account.enums.AccountType;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AccountDto {

    private String id;
    private String currency;
    private double balance;
    private LocalDate creationDate;
    private AccountStatus accountStatus;
    private AccountType accountType;
}
