package ru.korovin.authServer.controller;

import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.korovin.authServer.domain.dto.GetAccessRequest;
import ru.korovin.authServer.domain.dto.GetAccessResponse;
import ru.korovin.authServer.domain.dto.JwtRequest;
import ru.korovin.authServer.domain.dto.JwtResponse;
import ru.korovin.authServer.domain.exception.ResourceNotFoundException;
import ru.korovin.authServer.service.JWTCreationService;
import ru.korovin.authServer.service.JWTVerificationService;
import ru.korovin.authServer.service.UserService;

@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@RestController
public class AuthController {
    private final UserService userService;
    private final JWTCreationService jwtCreationService;
    private final JWTVerificationService jwtVerificationService;

    @PostMapping
    public JwtResponse authenticate(@RequestBody JwtRequest request){
        userService.getUserByHash(request.getHash());
        return new JwtResponse(jwtCreationService.createJWT(request));
    }

    @PostMapping("/validate")
    public GetAccessResponse hasAccess(@RequestBody GetAccessRequest request){
        try{
            jwtVerificationService.verify(request.getToken());
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
