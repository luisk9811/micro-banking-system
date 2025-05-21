package com.example.accountservice.gprc;

import com.example.accountservice.grpc.AccountRequest;
import com.example.accountservice.grpc.Transaction;
import com.example.accountservice.grpc.TransactionServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionConsumer {

    private final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
    private final TransactionServiceGrpc.TransactionServiceBlockingStub blockingStub = TransactionServiceGrpc.newBlockingStub(channel);

    public List<Transaction> getTransactions(Long accountId) {
        return blockingStub.getTransactionsByAccountId(
                AccountRequest.newBuilder()
                        .setAccountId(accountId)
                        .build())
                .getTransactionsList();
    }
}
