package com.trummy.inputservice.proxy;

import com.trummy.inputservice.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("user-service")
public interface UserProxy {

    @PostMapping("/user")
    UserDTO createNewUser(UserDTO newUser);

    @PostMapping("/user/{userId}/{mealId}")
    UserDTO addMealToUser(@PathVariable("userId") Long userId, @PathVariable("mealId") Long mealId);
}
