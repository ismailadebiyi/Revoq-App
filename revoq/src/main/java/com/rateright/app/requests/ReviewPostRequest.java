package com.rateright.app.requests;

public record ReviewPostRequest(
        Integer ratings,
        String comment
) {
}
