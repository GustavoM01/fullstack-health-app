package com.trummy.userservice.service;

import com.trummy.userservice.dao.User;
import com.trummy.userservice.dto.MealDTO;
import com.trummy.userservice.dto.UserDTO;
import com.trummy.userservice.proxy.MealProxy;
import com.trummy.userservice.repository.UserRepository;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final MealProxy mealProxy;

    public UserService(UserRepository userRepository, MealProxy mealProxy) {
        this.userRepository = userRepository;
        this.mealProxy = mealProxy;
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

    public MealDTO addMeal(Long userId, MealDTO newMeal) {
        Optional<User> foundUser = userRepository.findById(userId);
        MealDTO savedMeal;

        if (foundUser.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id: " + userId + " is not found in the database");

        try {
            savedMeal = mealProxy.saveMeal(newMeal);
        } catch (FeignException e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Meal could not be saved. Please try again later");
        }

        foundUser.get().addMeal(savedMeal.getId());
        userRepository.save(foundUser.get());
        return savedMeal;
    }
}
