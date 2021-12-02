package com.trummy.inputservice.service;

import com.trummy.inputservice.dto.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public interface InputServiceInterface {

    UserDTO createNewUser(UserDTO newUser);

    UserDTO addMealToUser(MealDTO newMeal);

    MealReturnDTO addIngredientsToMeal(Long mealId, IngredientsDTO ingredientsIds);

    SymptomDTO addNewSymptom(SymptomDTO newSymptom);
}
