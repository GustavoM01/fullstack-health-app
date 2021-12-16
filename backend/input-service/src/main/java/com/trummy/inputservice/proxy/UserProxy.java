package com.trummy.inputservice.proxy;

import com.trummy.inputservice.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("user-service")
public interface UserProxy {

    @GetMapping("/user/login/{username}")
    UserDTO login(@PathVariable("username") String username);

    @GetMapping("/user/{id}")
    UserDTO findUserById(@PathVariable("id") Long id);

    @GetMapping("/user")
    List<UserDTO> findAll();

    @PostMapping("/user")
    UserDTO createNewUser(UserDTO newUser);

    @PutMapping("/user/{userId}")
    UserDTO addMealToUser(@PathVariable("userId") Long userId, @RequestBody Long mealId);

    @PutMapping("/user/{userId}/delete-meal")
    UserDTO deleteMeal(@PathVariable("userId") Long userId, @RequestBody Long mealId);
}
