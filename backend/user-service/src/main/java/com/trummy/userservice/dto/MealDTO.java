package com.trummy.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MealDTO {

    private Long id;

    private String mealName;

    private List<Long> ingredients;

    private Date dateConsumed = new Date();

    private List<Long> symptoms;

    public MealDTO(String mealName, List<Long> ingredients, List<Long> symptoms) {
        this.mealName = mealName;
        this.ingredients = ingredients;
        this.symptoms = symptoms;
    }
}
