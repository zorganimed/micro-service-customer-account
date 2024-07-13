package com.mzo.account;

import com.mzo.account.entity.Account;
import com.mzo.account.enums.AccountStatus;
import com.mzo.account.enums.AccountType;
import com.mzo.account.repository.AccountRepository;
import com.mzo.account.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountService accountService, AccountRepository accountRepository){
		return args -> {

			accountRepository.save(Account.builder().id(UUID.randomUUID().toString())
					.currency("TND").creationDate(LocalDate.now()).balance(Math.random()*10000+9000)
					.customerId(1L).accountStatus(AccountStatus.SUSPENDED)
					.accountType(AccountType.SAVING_ACCOUNT).build());
			accountRepository.save(Account.builder().id(UUID.randomUUID().toString())
					.currency("EUR").creationDate(LocalDate.now()).balance(Math.random()*10000+9000)
					.customerId(1L).accountStatus(AccountStatus.ACTIVATED)
					.accountType(AccountType.SAVING_ACCOUNT).build());
			accountRepository.save(Account.builder().id(UUID.randomUUID().toString())
					.currency("USD").creationDate(LocalDate.now()).balance(Math.random()*10000+9000)
					.customerId(1L).accountStatus(AccountStatus.CREATED)
					.accountType(AccountType.CURRENT_ACCOUNT).build());
			accountRepository.save(Account.builder().id(UUID.randomUUID().toString())
					.currency("TND").creationDate(LocalDate.now()).balance(Math.random()*10000+9000)
					.customerId(1L).accountStatus(AccountStatus.BLOCKED)
					.accountType(AccountType.CURRENT_ACCOUNT).build());

			accountRepository.save(Account.builder().id(UUID.randomUUID().toString())
					.currency("USD").creationDate(LocalDate.now()).balance(Math.random()*10000+9000)
					.customerId(3L).accountStatus(AccountStatus.ACTIVATED)
					.accountType(AccountType.SAVING_ACCOUNT).build());
			accountRepository.save(Account.builder().id(UUID.randomUUID().toString())
					.currency("TND").creationDate(LocalDate.now()).balance(Math.random()*10000+9000)
					.customerId(3L).accountStatus(AccountStatus.SUSPENDED)
					.accountType(AccountType.CURRENT_ACCOUNT).build());
			accountRepository.save(Account.builder().id(UUID.randomUUID().toString())
					.currency("EUR").creationDate(LocalDate.now()).balance(Math.random()*10000+9000)
					.customerId(3L).accountStatus(AccountStatus.BLOCKED)
					.accountType(AccountType.SAVING_ACCOUNT).build());

			accountRepository.save(Account.builder().id(UUID.randomUUID().toString())
					.currency("EUR").creationDate(LocalDate.now()).balance(Math.random()*10000+9000)
					.customerId(2L).accountStatus(AccountStatus.SUSPENDED)
					.accountType(AccountType.CURRENT_ACCOUNT).build());
			accountRepository.save(Account.builder().id(UUID.randomUUID().toString())
					.currency("TND").creationDate(LocalDate.now()).balance(Math.random()*10000+9000)
					.customerId(2L).accountStatus(AccountStatus.ACTIVATED)
					.accountType(AccountType.SAVING_ACCOUNT).build());
		};
	}
}
