package com.trummy.userservice.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @ElementCollection
    private List<Long> mealList = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, List<Long> mealList) {
        this.username = username;
        this.password = password;
        this.mealList = mealList;
    }

    public void addMeal(Long mealId) {
        this.getMealList().add(mealId);
    }

    public void deleteMeal(Long mealId) {this.getMealList().remove(mealId);}
}
