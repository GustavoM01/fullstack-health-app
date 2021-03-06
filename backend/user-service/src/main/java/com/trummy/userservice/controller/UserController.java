package com.trummy.userservice.controller;

import com.trummy.userservice.dto.MealDTO;
import com.trummy.userservice.dto.UserDTO;
import com.trummy.userservice.service.UserService;
import com.trummy.userservice.dao.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping("/login/{username}")
    @ResponseStatus(HttpStatus.OK)
    public User login(@PathVariable("username") String username) { return userService.findByUsername(username);}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody @Valid UserDTO newUser) {
        return userService.save(newUser);
    }

    @PutMapping("/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public User addMeal(@PathVariable("userId") Long userId, @RequestBody Long mealId) { return userService.addMeal(userId, mealId);}

    @PutMapping("/{userId}/delete-meal")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User deleteMeal(@PathVariable("userId") Long userId, @RequestBody Long mealId) { return userService.deleteMeal(userId, mealId);}

}
