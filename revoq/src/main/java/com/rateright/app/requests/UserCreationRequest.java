package com.rateright.app.requests;

public record UserCreationRequest(
        String firstName,
        String lastName,
        String email,
        String password) {
}
