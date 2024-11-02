package com.essoft.ratelimiter.repository;

import com.essoft.ratelimiter.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
