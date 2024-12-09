package ru.korovin.authServer.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.korovin.authServer.domain.model.User;
import ru.korovin.authServer.repository.UserRepository;
import ru.korovin.authServer.service.UserService;

import java.lang.module.ResolutionException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Transactional
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserByHash(String hash) {
        return userRepository.findByHash(hash).orElseThrow(() -> new ResolutionException("No such user in database with hash %s".formatted(hash)));
    }

}