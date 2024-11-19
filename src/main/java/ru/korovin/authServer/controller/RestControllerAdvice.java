package ru.korovin.authServer.controller;

import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.korovin.authServer.domain.dto.ExceptionDto;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {
    @ExceptionHandler
    public ExceptionDto handleJwtVerificationException(JWTVerificationException e){
        return new ExceptionDto(e.getMessage(), Timestamp.from(Instant.now()));
    }
}
