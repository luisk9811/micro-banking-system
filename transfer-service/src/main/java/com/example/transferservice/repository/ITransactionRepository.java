package com.example.transferservice.repository;

import com.example.transferservice.model.Transaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ITransactionRepository extends ReactiveCrudRepository<Transaction, Long> {
    Flux<Transaction> findByAccountId(Long accountId);
}
