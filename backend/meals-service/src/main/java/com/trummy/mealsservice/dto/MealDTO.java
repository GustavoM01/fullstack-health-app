package com.trummy.mealsservice.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MealDTO {

    private String mealName;

    private List<Long> ingredients;

    private Date dateConsumed = new Date();

    public MealDTO(String mealName, List<Long> ingredients) {
        this.mealName = mealName;
        this.ingredients = ingredients;
    }
}
