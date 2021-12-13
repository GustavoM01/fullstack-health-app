package com.trummy.inputservice.proxy;

import com.trummy.inputservice.dto.IngredientsDTO;
import com.trummy.inputservice.dto.MealDTO;
import com.trummy.inputservice.dto.MealReturnDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@FeignClient("meal-service")
public interface MealProxy {

    @GetMapping("/meal")
    List<MealReturnDTO> findAll();

    @PostMapping("/meal")
    MealDTO addMeal(MealDTO newMeal);

    @PutMapping("/meal/{mealId}")
    MealReturnDTO addIngredientsToMeal(@PathVariable("mealId") Long mealId, IngredientsDTO ingredientsIds);
}
