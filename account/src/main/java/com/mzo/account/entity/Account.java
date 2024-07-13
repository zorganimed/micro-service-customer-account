package com.mzo.account.entity;

import com.mzo.account.enums.AccountStatus;
import com.mzo.account.enums.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class Account {

    @Id
    private String id;
    private String currency;
    private double balance;
    private LocalDate creationDate;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private Long customerId;
}
