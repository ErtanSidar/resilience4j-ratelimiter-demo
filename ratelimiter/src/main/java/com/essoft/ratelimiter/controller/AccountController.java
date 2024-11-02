package com.essoft.ratelimiter.controller;

import com.essoft.ratelimiter.model.Account;
import com.essoft.ratelimiter.service.AccountService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("findAll")
    @RateLimiter(name = "ertan", fallbackMethod = "getFallback")
    public ResponseEntity<List<Account>> findAll() {
        return new ResponseEntity<>(accountService.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> getFallback() {
        return new ResponseEntity<>("You can make up to 3 requests in 1 minute.", HttpStatus.TOO_MANY_REQUESTS);
    }
}
