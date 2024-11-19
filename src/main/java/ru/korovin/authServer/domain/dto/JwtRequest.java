package ru.korovin.authServer.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class JwtRequest {
    private String hash;

    @JsonCreator
    public JwtRequest(@JsonProperty("hash") String hash) {
        this.hash = hash;
    }
}
