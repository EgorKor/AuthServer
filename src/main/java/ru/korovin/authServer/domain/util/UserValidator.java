package ru.korovin.authServer.domain.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.korovin.authServer.domain.dto.UserDto;
import ru.korovin.authServer.domain.model.User;
import ru.korovin.authServer.repository.UserRepository;

@RequiredArgsConstructor
@Component
public class UserValidator implements Validator {
    private final UserRepository userRepository;


    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto dto = (UserDto) target;
        if(userRepository.findByHash(dto.getHash()).isPresent()){
            errors.rejectValue("hash","","hash should be unique");
        }
    }

}
