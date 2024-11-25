package ru.korovin.authServer.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class ValidationException extends RuntimeException {
    private List<String> messages;

    public static List<String> convertToList(List<FieldError> errors){
        List<String> list = new ArrayList<>();
        for(FieldError error : errors){
            list.add(error.getDefaultMessage());
        }
        return list;
    }

}
