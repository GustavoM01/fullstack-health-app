package com.trummy.inputservice.service;

import com.trummy.inputservice.dto.*;
import com.trummy.inputservice.proxy.IngredientProxy;
import com.trummy.inputservice.proxy.MealProxy;
import com.trummy.inputservice.proxy.SymptomProxy;
import com.trummy.inputservice.proxy.UserProxy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("open-feign")
public class InputServiceFeign implements InputServiceInterface{

    private final UserProxy userProxy;
    private final MealProxy mealProxy;
    private final IngredientProxy ingredientProxy;
    private final SymptomProxy symptomProxy;

    public InputServiceFeign(UserProxy userProxy, MealProxy mealProxy, IngredientProxy ingredientProxy, SymptomProxy symptomProxy) {
        this.userProxy = userProxy;
        this.mealProxy = mealProxy;
        this.ingredientProxy = ingredientProxy;
        this.symptomProxy = symptomProxy;
    }

    @Override
    public UserDTO login(String user) {
        return userProxy.login(user);
    }

    @Override
    public UserDTO createNewUser(UserDTO newUser) {
        UserDTO createdUser = userProxy.createNewUser(newUser);
        return createdUser;
    }

    @Override
    public UserDTO addMealToUser(MealDTO newMeal) {
        MealDTO savedMeal = mealProxy.addMeal(newMeal);
        UserDTO updatedUser = userProxy.addMealToUser(newMeal.getUserId(), savedMeal.getMealId());

        return updatedUser;
    }

    @Override
    public MealReturnDTO addIngredientsToMeal(Long mealId, IngredientsDTO ingredientsIds) {
        MealReturnDTO updatedMeal = mealProxy.addIngredientsToMeal(mealId, ingredientsIds);
        return updatedMeal;
    }

    @Override
    public SymptomDTO addNewSymptom(SymptomDTO newSymptom) {
        SymptomDTO addedSymptom = symptomProxy.addNewSymptom(newSymptom);
        return addedSymptom;
    }
}
