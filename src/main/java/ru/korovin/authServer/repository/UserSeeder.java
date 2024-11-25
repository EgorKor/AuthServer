package ru.korovin.authServer.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.korovin.authServer.domain.model.User;

@Component
@RequiredArgsConstructor
public class UserSeeder implements CommandLineRunner {
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        User user = new User(null,"b23cf2d0fb74b0ffa0cf4c70e6e04926", "Egor","Korovin","Alexandrovich");
        userRepository.save(user);
    }
}
