package com.rateright.app.requests;

public record CreateTransactionRequest(
        Long customerId,
        String transactionDetails
) {
}
