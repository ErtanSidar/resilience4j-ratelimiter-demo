package com.essoft.ratelimiter;

import com.essoft.ratelimiter.model.Account;
import com.essoft.ratelimiter.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RatelimiterApplication implements CommandLineRunner {

	private final AccountRepository accountRepository;

    public RatelimiterApplication(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(RatelimiterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Account account = new Account("Ertan","Sidar");
		accountRepository.save(account);
	}
}
