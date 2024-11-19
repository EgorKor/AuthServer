package ru.korovin.authServer.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import ru.korovin.authServer.domain.dto.JwtRequest;
import ru.korovin.authServer.service.JWTCreationService;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class JWTCreationServiceImpl implements JWTCreationService {
    private final Environment environment;
    @Override
    public String createJWT(JwtRequest request) {
        return JWT
                .create()
                .withClaim("hash",request.getHash())
                .sign(Algorithm.HMAC256(Objects.requireNonNull(environment.getProperty("jwt.secret"))));
    }
}
