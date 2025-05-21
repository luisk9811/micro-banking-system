package com.example.transactionservice.service;

import com.example.transactionservice.dto.AccountDTO;
import com.example.transactionservice.dto.TransferDTO;
import com.example.transactionservice.model.Transaction;
import com.example.transactionservice.repository.ITransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final ITransactionRepository transactionRepository;
    private final AccountClient accountClient;

    public Flux<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    public Mono<Void> makeTransaction(TransferDTO transfer) {

        BigDecimal amount = transfer.getAmount();

        return accountClient.getAccount(transfer.getSourceAccountId())
                .zipWith(accountClient.getAccount(transfer.getDestinationAccountId()))
                .flatMap(tuple -> {
                    AccountDTO source = tuple.getT1();
                    AccountDTO destination = tuple.getT2();

                    if (source.getBalance().compareTo(amount) < 0) {
                        return Mono.error(new RuntimeException("Insufficient funds"));
                    }

                    source.setBalance(source.getBalance().subtract(amount));
                    Transaction withdrawal = new Transaction(null, "RETIRO", source.getId(), amount, "Transfer to " + destination.getId(), LocalDateTime.now());

                    if (source.getBankId().equals(destination.getBankId())) {
                        destination.setBalance(destination.getBalance().add(amount));
                        Transaction deposit = new Transaction(null, "DEPOSITO", destination.getId(), amount, "Transfer from " + source.getId(), LocalDateTime.now());

                        return Mono.when(
                                accountClient.updateAccount(source),
                                accountClient.updateAccount(destination),
                                transactionRepository.save(withdrawal),
                                transactionRepository.save(deposit)
                        ).then();
                    } else {
//                        // Interbancaria: solo retiro y enviar evento
//                        DepositEvent depositEvent = new DepositEvent(destination.getId(), amount, "Interbank transfer");
//
//                        return Mono.when(
//                                updateAccount(source),
//                                transactionRepository.save(withdrawal),
//                                eventPublisher.publish(depositEvent) // lo envías a la cola
//                        ).then();
                        destination.setBalance(destination.getBalance().add(amount));
                        Transaction deposit = new Transaction(null, "DEPOSITO", destination.getId(), amount, "Transfer from " + source.getId(), LocalDateTime.now());

                        return Mono.when(
                                accountClient.updateAccount(source),
                                accountClient.updateAccount(destination),
                                transactionRepository.save(withdrawal),
                                transactionRepository.save(deposit)
                        ).then();
                    }
                });
    }

}
