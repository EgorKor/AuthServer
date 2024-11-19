package ru.korovin.authServer.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class ExceptionDto {
    private String message;
    private Timestamp timestamp;
}
