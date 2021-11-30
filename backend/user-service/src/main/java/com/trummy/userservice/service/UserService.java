package com.trummy.userservice.service;

import com.trummy.userservice.dao.User;
import com.trummy.userservice.dto.UserDTO;
import com.trummy.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User save(UserDTO newUser) {
        // Check if username is taken
        if (userRepository.findByUsername(newUser.getUsername()).isPresent())
            throw new IllegalArgumentException("Username is taken");
        User newUserEntity =
                new User(newUser.getUsername(), newUser.getPassword());
        return userRepository.save(newUserEntity);
    }
}
