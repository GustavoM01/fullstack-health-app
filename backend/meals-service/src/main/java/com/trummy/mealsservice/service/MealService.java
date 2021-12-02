package com.trummy.mealsservice.service;

import com.trummy.mealsservice.dao.Meal;
import com.trummy.mealsservice.dto.IngredientsDTO;
import com.trummy.mealsservice.dto.MealDTO;
import com.trummy.mealsservice.repository.MealRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MealService {

    private final MealRepository mealRepository;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public List<Meal> findAll() {
        return mealRepository.findAll();
    }

    public Meal findById(Long id) {
        Optional<Meal> foundMeal = mealRepository.findById(id);
        return foundMeal.orElse(null);
    }

    public Meal save(MealDTO newMeal) {
        Meal meal = new Meal(newMeal.getMealName(), newMeal.getIngredients());
        return mealRepository.save(meal);
    }

    public Meal addIngredients(Long mealId, IngredientsDTO ingredientsIds) {
        Optional<Meal> foundMeal = mealRepository.findById(mealId);
        if (foundMeal.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no meal by that id");
        foundMeal.get().addIngredients(ingredientsIds);
        return mealRepository.save(foundMeal.get());
    }
}
