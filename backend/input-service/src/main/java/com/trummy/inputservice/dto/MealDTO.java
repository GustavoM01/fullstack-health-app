package com.trummy.inputservice.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class MealDTO {

    private Long mealId;

    private Long userId;

    @NotBlank
    private String mealName;

    private List<Long> ingredients;

    private Date dateConsumed;
}
