package com.mzo.customer.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CustomerDto {

    private String firstName;
    private String lastName;
    private String email;
}
