package ru.korovin.authServer.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import ru.korovin.authServer.domain.dto.GetAccessRequest;
import ru.korovin.authServer.domain.dto.GetAccessResponse;
import ru.korovin.authServer.domain.dto.JwtRequest;
import ru.korovin.authServer.domain.dto.JwtResponse;
import ru.korovin.authServer.domain.exception.ResourceNotFoundException;
import ru.korovin.authServer.domain.model.User;
import ru.korovin.authServer.repository.UserRepository;
import ru.korovin.authServer.service.UserService;

import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@RestController
public class AuthController {
    private final JWTVerifier jwtVerifier;
    private final UserService userService;
    private final Environment environment;

    @PostMapping
    public JwtResponse authenticate(@RequestBody JwtRequest request){
        userService.getUserByHash(request.getHash());
        return new JwtResponse(JWT
                .create()
                .withClaim("hash",request.getHash())
                .sign(Algorithm.HMAC256(Objects.requireNonNull(environment.getProperty("jwt.secret")))));
    }

    @PostMapping("/validate")
    public GetAccessResponse hasAccess(@RequestBody GetAccessRequest request){
        try{
            DecodedJWT decodedJWT = jwtVerifier.verify(request.getToken());
            String hash = decodedJWT.getClaim("hash").asString();
            userService.getUserByHash(hash);
        }catch (ResourceNotFoundException | JWTVerificationException e){
            return new GetAccessResponse(false);
        }
        return new GetAccessResponse(true);
    }

    @GetMapping("/echo")
    public String echo(){
        System.out.println("echo");
        return "echo";
    }
}
