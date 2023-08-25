package app.domain.service;

import app.domain.controller.request.UserRequest;
import app.domain.entity.User;
import app.infrastructure.database.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(UUID id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User save(UserRequest userRequest) {
        User user = new User();
        user.setFirstname(userRequest.getFirstname());
        user.setLastname(userRequest.getLastname());
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        user.setStatus(false);
        user.setCreated(LocalDateTime.now());
        return userRepository.save(user);
    }

    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }
}
