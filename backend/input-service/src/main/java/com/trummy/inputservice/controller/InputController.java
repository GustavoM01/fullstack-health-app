package com.trummy.inputservice.controller;

import com.trummy.inputservice.dto.*;
import com.trummy.inputservice.service.InputServiceInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/input")
public class InputController {

    private final InputServiceInterface inputService;

    public InputController(@Qualifier("open-feign") InputServiceInterface inputService) {
        this.inputService = inputService;
    }

    // USER-SERVICE
    @GetMapping("/user/login/{username}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO login (@PathVariable("username") String username) {return inputService.login(username);}

    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findUserById(@PathVariable("id") Long id) {return inputService.findUser(id);}

    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> findAllUsers() {return inputService.findAllUsers();}

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createNewUser(@RequestBody @Valid UserDTO newUser) {
        return inputService.createNewUser(newUser);
    }

    @PutMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO addMealToUser(@PathVariable("id") Long id, @RequestBody Long mealId) { return inputService.addMealToUser(id, mealId);}

    @PutMapping("/user/{id}/delete-meal")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserDTO deleteMealFromUser(@PathVariable("id") Long id, @RequestBody Long mealToDelete) {
        return inputService.deleteMeal(id, mealToDelete);
    }


    // MEAL-SERVICE
    @GetMapping("/meal")
    @ResponseStatus(HttpStatus.OK)
    public List<MealReturnDTO> findAllMeals() {
        return inputService.findAllMeals();
    }

    @PutMapping("/meal/add-ingredients/{mealId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public MealReturnDTO addIngredientsToMeal(@PathVariable("mealId") Long mealId, @RequestBody IngredientsDTO ingredientsIds) {
        return inputService.addIngredientsToMeal(mealId, ingredientsIds);
    }

    @PutMapping("/meal/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public MealReturnDTO updateMeal(@RequestBody MealReturnDTO updateMeal) {
        return inputService.updateMeal(updateMeal);
    }

    @PostMapping("/meal")
    @ResponseStatus(HttpStatus.OK)
    public MealReturnDTO addMealToUser(@RequestBody @Valid MealDTO newMeal) { return inputService.saveMeal(newMeal);}

    // INGREDIENT-SERVICE
    @GetMapping("/ingredient")
    @ResponseStatus(HttpStatus.OK)
    public List<IngredientReturnDTO> findAllIngredients() {
        return inputService.findAllIngredients();
    }

    // SYMPTOM-SERVICE
    @PostMapping("/symptom")
    @ResponseStatus(HttpStatus.CREATED)
    public SymptomDTO addNewSymptom(@RequestBody @Valid SymptomDTO newSymptom) {
        return inputService.addNewSymptom(newSymptom);
    }

}
