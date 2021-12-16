package com.trummy.mealsservice.dao;

import com.trummy.mealsservice.dto.IngredientsDTO;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mealId;

    private String mealName;

    @ElementCollection
    private List<Long> ingredients = new ArrayList<>();

    private Date dateConsumed = new Date();

    public Meal(String mealName, List<Long> ingredients) {
        this.mealName = mealName;
        this.ingredients = ingredients;
    }

    public Meal(String mealName, List<Long> ingredients, Date dateConsumed) {
        this.mealName = mealName;
        this.ingredients = ingredients;
        this.dateConsumed = dateConsumed;
    }

    public void addIngredients(IngredientsDTO newIngredients) {
        ingredients.addAll(newIngredients.getIngredientsIds());
    }
}
