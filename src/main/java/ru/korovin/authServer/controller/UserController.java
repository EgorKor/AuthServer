package ru.korovin.authServer.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jline.keymap.BindingReader;
import org.modelmapper.ModelMapper;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.korovin.authServer.domain.dto.UserDto;
import ru.korovin.authServer.domain.exception.ValidationException;
import ru.korovin.authServer.domain.model.User;
import ru.korovin.authServer.domain.util.UserValidator;
import ru.korovin.authServer.service.UserService;

import java.util.List;
import java.util.Objects;


@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@RestController
@CrossOrigin(methods = {RequestMethod.POST}, origins = {"http://localhost"})
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final UserValidator userValidator;

    @PostMapping("/save")
    public void saveUser(@RequestBody @Valid UserDto dto, BindingResult bindingResult){
        userValidator.validate(dto, bindingResult);
        if(bindingResult.hasErrors()){
            throw new ValidationException(ValidationException.convertToList(bindingResult.getFieldErrors()));
        }
        User user = modelMapper.map(dto, User.class);
        userService.save(user);
    }

}
