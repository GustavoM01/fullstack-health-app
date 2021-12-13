package com.trummy.inputservice.service;

import com.trummy.inputservice.dto.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public interface InputServiceInterface {

    UserDTO login(String user);

    UserDTO findUser(Long id);

    UserDTO createNewUser(UserDTO newUser);

    UserDTO addMealToUser(MealDTO newMeal);

    List<MealReturnDTO> findAllMeals();

    MealReturnDTO addIngredientsToMeal(Long mealId, IngredientsDTO ingredientsIds);

    List<IngredientReturnDTO> findAllIngredients();

    SymptomDTO addNewSymptom(SymptomDTO newSymptom);
}
