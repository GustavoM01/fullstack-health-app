package com.trummy.inputservice.service;

import com.trummy.inputservice.dto.*;
import com.trummy.inputservice.proxy.IngredientProxy;
import com.trummy.inputservice.proxy.MealProxy;
import com.trummy.inputservice.proxy.SymptomProxy;
import com.trummy.inputservice.proxy.UserProxy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
    public UserDTO findUser(Long id) {
        return userProxy.findUserById(id);
    }

    @Override
    public List<UserDTO> findAllUsers() {return userProxy.findAll();}

    @Override
    public UserDTO createNewUser(UserDTO newUser) {
        UserDTO createdUser = userProxy.createNewUser(newUser);
        return createdUser;
    }

    @Override
    public UserDTO addMealToUser(Long id, Long mealId) {
        return userProxy.addMealToUser(id, mealId);
    }

    @Override
    public UserDTO deleteMeal(Long id, Long mealToDelete) {
        mealProxy.deleteMeal(mealToDelete);
        return userProxy.deleteMeal(id, mealToDelete);
    }

    @Override
    public List<MealReturnDTO> findAllMeals() {
        return mealProxy.findAll();
    }

    @Override
    public MealReturnDTO saveMeal(MealDTO newMeal) {
        return mealProxy.addMeal(newMeal);
    }

    @Override
    public MealReturnDTO addIngredientsToMeal(Long mealId, IngredientsDTO ingredientsIds) {
        MealReturnDTO updatedMeal = mealProxy.addIngredientsToMeal(mealId, ingredientsIds);
        return updatedMeal;
    }

    @Override
    public MealReturnDTO updateMeal(@RequestBody MealReturnDTO updateMeal) {
        return mealProxy.updateMeal(updateMeal);
    }

    @Override
    public List<IngredientReturnDTO> findAllIngredients() {
        return ingredientProxy.findAll();
    }

    @Override
    public List<SymptomDTO> findAllSymptoms() {
        return symptomProxy.findAll();
    }

    @Override
    public List<SymptomDTO> findAllSymptomsByUser(Long userId) {
        return symptomProxy.findAllByUser(userId);
    }

    @Override
    public SymptomDTO updateSymptom(SymptomDTO updateSymptom) {
        return symptomProxy.updateSymptom(updateSymptom);
    }

    @Override
    public SymptomDTO addNewSymptom(SymptomDTO newSymptom) {
        SymptomDTO addedSymptom = symptomProxy.addNewSymptom(newSymptom);
        return addedSymptom;
    }

    @Override
    public void deleteSymptom(Long symptomId) {
        symptomProxy.delete(symptomId);
    }
}
