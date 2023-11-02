package com.rateright.app.requests;

public record CustomerRegistrationRequest(
        String companyName,
        String email,
        Integer phoneNumber,
        Long userId,
        byte avatar) {
}
