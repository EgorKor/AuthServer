package ru.korovin.authServer.service.impl;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.korovin.authServer.service.JWTVerificationService;
import ru.korovin.authServer.service.UserService;

@Service
@RequiredArgsConstructor
public class JWTVerificationServiceImpl implements JWTVerificationService {
    private final JWTVerifier jwtVerifier;
    private final UserService userService;
    @Override
    public void verify(String token) {
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        String hash = decodedJWT.getClaim("hash").asString();
        userService.getUserByHash(hash);
    }
}
