package com.trummy.inputservice.controller;

import com.trummy.inputservice.dto.*;
import com.trummy.inputservice.service.InputServiceInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createNewUser(@RequestBody @Valid UserDTO newUser) {
        return inputService.createNewUser(newUser);
    }

    // MEAL-SERVICE
    @PostMapping("/user/add-meal")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO addMealToUser(@RequestBody @Valid MealDTO newMeal) {
        return inputService.addMealToUser(newMeal);
    }

    @PutMapping("/meal/add-ingredients/{mealId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public MealReturnDTO addIngredientsToMeal(@PathVariable("mealId") Long mealId, @RequestBody IngredientsDTO ingredientsIds) {
        return inputService.addIngredientsToMeal(mealId, ingredientsIds);
    }

    // SYMPTOM-SERVICE
    @PostMapping("/symptom")
    @ResponseStatus(HttpStatus.CREATED)
    public SymptomDTO addNewSymptom(@RequestBody @Valid SymptomDTO newSymptom) {
        return inputService.addNewSymptom(newSymptom);
    }

}
