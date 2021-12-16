package com.trummy.mealsservice.controller;

import com.trummy.mealsservice.dao.Meal;
import com.trummy.mealsservice.dto.IngredientsDTO;
import com.trummy.mealsservice.dto.MealDTO;
import com.trummy.mealsservice.repository.MealRepository;
import com.trummy.mealsservice.service.MealService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/meal")
public class MealController {

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping
    public List<Meal> findAll() {
        return mealService.findAll();
    }

    @GetMapping("/{id}")
    public Meal findById(@PathVariable(name = "id") Long id) {
        return mealService.findById(id);
    }

    @PostMapping
    public Meal postMeal(@RequestBody MealDTO newMeal) {
        return mealService.save(newMeal);
    }

    @PutMapping("/{mealId}")
    public Meal addIngredients(@PathVariable("mealId") Long mealId, @RequestBody IngredientsDTO ingredientsIds) {
        return mealService.addIngredients(mealId, ingredientsIds);
    }

    @DeleteMapping("/{mealId}")
    public void deleteMeal(@PathVariable("mealId") Long mealId) {
        mealService.deleteMeal(mealId);
    }

}
