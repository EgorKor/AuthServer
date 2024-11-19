package ru.korovin.authServer.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GetAccessResponse {
    boolean hasAccess;

    @JsonCreator
    public GetAccessResponse(@JsonProperty("hasAccess") boolean hasAccess) {
        this.hasAccess = hasAccess;
    }
}
