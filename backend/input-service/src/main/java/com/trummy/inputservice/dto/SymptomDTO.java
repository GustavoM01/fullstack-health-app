package com.trummy.inputservice.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class SymptomDTO {

    private Long id;

    @NotNull
    private Long userId;

    @NotBlank
    private String name;

    private String description;

    private String intensity;

    private Date timeOfSymptom;
}
