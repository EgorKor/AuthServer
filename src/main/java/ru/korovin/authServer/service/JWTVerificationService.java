package ru.korovin.authServer.service;

public interface JWTVerificationService {
    void verify(String token);
}
