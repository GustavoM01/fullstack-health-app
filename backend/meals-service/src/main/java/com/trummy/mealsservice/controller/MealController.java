package com.trummy.mealsservice.controller;

import com.trummy.mealsservice.dao.Meal;
import com.trummy.mealsservice.dto.MealDTO;
import com.trummy.mealsservice.repository.MealRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/meal")
public class MealController {

    private MealRepository mealRepository;

    public MealController(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @GetMapping
    public List<Meal> findAll() {
        return mealRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Meal> findById(@PathVariable(name = "id") Long id) {
        return mealRepository.findById(id);
    }

    @PostMapping
    public Meal postMeal(@RequestBody MealDTO meal) {
        Meal newMeal = new Meal(meal.getMealName(), meal.getIngredients(), meal.getDateConsumed(), meal.getSymptoms());

        return mealRepository.save(newMeal);
    }
}
