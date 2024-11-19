package ru.korovin.authServer.repository;

import org.jline.utils.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.korovin.authServer.domain.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByHash(String hash);
    void deleteUserByHash(String hash);
}
