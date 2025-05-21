package com.example.accountservice.controller;

import com.example.accountservice.dto.TransactionDTO;
import com.example.accountservice.model.Account;
import com.example.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {
  private final AccountService accountService;

  @GetMapping
  public Flux<Account> getAll() {
    return accountService.getAll();
  }

  @GetMapping("/{accountId}")
  public Mono<Account> getById(@PathVariable Long accountId) {
    return accountService.getById(accountId);
  }

  @PostMapping
  public Mono<Account> create(@RequestBody Account account) {
    return accountService.create(account);
  }

  @PutMapping
  public Mono<Account> update(@RequestBody Account account) {
    return accountService.update(account);
  }

  @GetMapping("/movements/{accountId}")
  public Flux<TransactionDTO> getMovements(@PathVariable Long accountId) {
    return accountService.getMovements(accountId);
  }
}
