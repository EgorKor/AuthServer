package ru.korovin.authServer.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@AllArgsConstructor
public class ExceptionDto {
    private List<String> messages;
    private Timestamp timestamp;
}
