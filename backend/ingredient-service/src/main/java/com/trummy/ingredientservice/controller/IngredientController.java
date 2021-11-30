package com.trummy.ingredientservice.controller;

import com.trummy.ingredientservice.dao.Ingredient;
import com.trummy.ingredientservice.dto.IngredientDTO;
import com.trummy.ingredientservice.service.IngredientService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<Ingredient> ingredientList() {
        return ingredientService.findAllIngredients();
    }

    @GetMapping("/{ingredientId}")
    public Ingredient findIngredientById(@PathVariable("ingredientId") Long ingredientId) {
        return ingredientService.findIngredientById(ingredientId);
    }

    @PostMapping
    public Ingredient saveNewIngredient(@RequestBody @Valid IngredientDTO newIngredient) {
        return ingredientService.saveIngredient(newIngredient);
    }
}
