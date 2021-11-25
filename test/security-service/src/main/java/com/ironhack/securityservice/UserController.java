package com.ironhack.securityservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable(name = "id") Long id) {
        return userRepository.findById(id);
    }

    @PostMapping
    public User postUser(@RequestBody UserDTO user) {
        User newUser = new User(user.getName(), user.getPassword());
        return userRepository.save(newUser);
    }
}
