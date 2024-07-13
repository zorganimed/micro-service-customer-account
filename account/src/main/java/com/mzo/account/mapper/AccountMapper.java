package com.mzo.account.mapper;

import com.mzo.account.dto.AccountDto;
import com.mzo.account.entity.Account;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AccountMapper {

    ModelMapper modelMapper = new ModelMapper();

    public Account toAccount(AccountDto accountDto){
        return modelMapper.map(accountDto,Account.class);
    }

    public AccountDto fromAccount(Account account){
        return modelMapper.map(account,AccountDto.class);
    }
}
