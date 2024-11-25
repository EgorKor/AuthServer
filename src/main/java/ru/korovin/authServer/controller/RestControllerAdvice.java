package ru.korovin.authServer.controller;

import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.korovin.authServer.domain.dto.ExceptionDto;
import ru.korovin.authServer.domain.exception.ValidationException;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {
    @ExceptionHandler
    public ExceptionDto handleJwtVerificationException(JWTVerificationException e){
        return new ExceptionDto(List.of(e.getMessage()), Timestamp.from(Instant.now()));
    }

    @ExceptionHandler
    public ExceptionDto handleValidationException(ValidationException e){
        return new ExceptionDto(e.getMessages(), Timestamp.from(Instant.now()));
    }
}
