package ru.korovin.authServer.domain.exception;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class ResourceNotFoundException extends RuntimeException{
    private String message;
}
