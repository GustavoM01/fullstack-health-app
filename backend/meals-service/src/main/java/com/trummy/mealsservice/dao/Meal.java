package com.trummy.mealsservice.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
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

}
