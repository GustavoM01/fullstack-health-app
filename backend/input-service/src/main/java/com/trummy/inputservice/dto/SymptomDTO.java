package com.trummy.inputservice.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class SymptomDTO {

    @NotNull
    private Long userId;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    private String intensity;

    private Date timeOfSymptom = new Date();
}
