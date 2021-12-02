package com.trummy.mealsservice.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class IngredientsDTO {

    private List<Long> ingredientsIds;

}
