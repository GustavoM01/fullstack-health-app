package com.trummy.userservice.proxy;

import com.trummy.userservice.dto.MealDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("meal-service")
public interface MealProxy {



    @PostMapping("/meal")
    MealDTO saveMeal(@RequestBody MealDTO newMeal);
}
