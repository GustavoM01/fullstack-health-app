package com.trummy.mealsservice.dao;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
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
    private Long id;

    private String mealName;

    @ElementCollection
    private List<Long> ingredients = new ArrayList<>();

    private Date dateConsumed = new Date();

    @ElementCollection
    private List<Long> symptoms = new ArrayList<>();

    public Meal(String mealName, List<Long> ingredients, Date dateConsumed, List<Long> symptoms) {
        this.mealName = mealName;
        this.ingredients = ingredients;
        this.dateConsumed = dateConsumed;
        this.symptoms = symptoms;
    }
}
