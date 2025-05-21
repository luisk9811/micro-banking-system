package com.example.transferservice.service;

import com.example.transferservice.model.Transaction;
import com.example.transferservice.repository.ITransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TransferService {
    private final ITransactionRepository transactionRepository;
    private final AccountClient accountClient;

    public Mono<Void> saveTransaction(Transaction deposit) {
        return accountClient.getAccount(deposit.getAccountId())
                .flatMap(destination -> {
                    destination.setBalance(destination.getBalance().add(deposit.getAmount()));
                    return Mono.when(
                            accountClient.updateAccount(destination),
                            transactionRepository.save(deposit)
                    ).then();
                });
    }

}
