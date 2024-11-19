package ru.korovin.authServer.service;

import ru.korovin.authServer.domain.dto.JwtRequest;

public interface JWTCreationService {
    String createJWT(JwtRequest request);
}
