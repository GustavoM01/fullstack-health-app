package com.trummy.inputservice.service;

import com.trummy.inputservice.dto.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public interface InputServiceInterface {

    // USER
    UserDTO login(String user);

    UserDTO findUser(Long id);

    List<UserDTO> findAllUsers();

    UserDTO createNewUser(UserDTO newUser);

    UserDTO addMealToUser(Long id, Long mealId);

    UserDTO deleteMeal(Long id, Long mealToDelete);

    // MEAL
    List<MealReturnDTO> findAllMeals();

    MealReturnDTO addIngredientsToMeal(Long mealId, IngredientsDTO ingredientsIds);

    MealReturnDTO saveMeal(MealDTO mealDTO);

    MealReturnDTO updateMeal(MealReturnDTO updateMeal);

    // INGREDIENT
    List<IngredientReturnDTO> findAllIngredients();

    SymptomDTO addNewSymptom(SymptomDTO newSymptom);
}
