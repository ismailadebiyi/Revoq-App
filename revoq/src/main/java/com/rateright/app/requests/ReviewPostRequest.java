package com.rateright.app.requests;

public record ReviewPostRequest(
        Long customerId,
        Integer ratings,
        String comment
) {
}
