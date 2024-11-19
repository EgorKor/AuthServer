package ru.korovin.authServer.service;

import org.springframework.stereotype.Service;
import ru.korovin.authServer.domain.model.User;


public interface UserService {
    User save(User user);
    User getUserByHash(String hash);
}
