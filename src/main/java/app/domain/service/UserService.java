package app.domain.service;

import app.domain.controller.request.UserRequest;
import app.domain.entity.User;
import app.infrastructure.database.UserRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public UserService(UserRepository userRepository, KafkaTemplate<String, String> kafkaTemplate) {
        this.userRepository = userRepository;
        this.kafkaTemplate = kafkaTemplate;
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
        User saved = userRepository.save(user);
        kafkaTemplate.send("baeldung", saved.getId().toString());
        return saved;
    }

    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }
}
