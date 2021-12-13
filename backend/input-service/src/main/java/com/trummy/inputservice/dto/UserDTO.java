package com.trummy.inputservice.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class UserDTO {

    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private List<Long> mealList;
}
