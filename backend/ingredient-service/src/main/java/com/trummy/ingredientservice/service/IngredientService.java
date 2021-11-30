package com.trummy.ingredientservice.service;

import com.trummy.ingredientservice.dao.Ingredient;
import com.trummy.ingredientservice.dto.IngredientDTO;
import com.trummy.ingredientservice.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> findAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient findIngredientById(Long ingredientId) {
       Optional<Ingredient> foundIngredient = ingredientRepository.findById(ingredientId);
       return foundIngredient.orElse(null);
    }

    public Ingredient saveIngredient(IngredientDTO newIngredient) {
        Ingredient ingredient =
                new Ingredient(
                        newIngredient.getName());

        return ingredientRepository.save(ingredient);
    }
}
