package com.example.accountservice.service;

import com.example.accountservice.model.Account;
import com.example.accountservice.repository.IAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final IAccountRepository bankRepository;
    private final GetBankClient getBankClient;

    public Flux<Account> getAll() {
        return bankRepository.findAll();
    }

    public Mono<Account> getById(Long accountId) {
        return bankRepository
                .findById(accountId)
                .switchIfEmpty(Mono.error(new RuntimeException("Account not found")));
    }

    public Mono<Account> create(Account account) {
        account.setId(null);
        return getBankClient.getBank(account.getBankId())
                .flatMap(bank -> bankRepository.save(account));
    }

    public Mono<Account> update(Account account) {
        return bankRepository.findById(account.getId())
                .switchIfEmpty(Mono.error(new RuntimeException("Account not found")))
                .flatMap(existingAccount ->
                        getBankClient.getBank(account.getBankId())
                                .flatMap(bank -> {
                                    existingAccount.setAccountNumber(account.getAccountNumber());
                                    existingAccount.setBankId(account.getBankId());
                                    existingAccount.setAccountType(account.getAccountType());
                                    existingAccount.setBalance(account.getBalance());
                                    existingAccount.setStatus(account.getStatus());
                                    return bankRepository.save(existingAccount);
                                }));
    }

}
