package com.mzo.account.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Customer {

    private String firstName;
    private String lastName;
    private String email;
}
