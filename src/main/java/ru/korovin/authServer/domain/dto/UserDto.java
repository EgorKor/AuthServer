package ru.korovin.authServer.domain.dto;

import jakarta.persistence.Column;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserDto {
    @Length(min = 32, max = 32, message = "Hash should be 32 length")
    private String hash;

    private String name;

    private String surname;

    private String secondName;
}
