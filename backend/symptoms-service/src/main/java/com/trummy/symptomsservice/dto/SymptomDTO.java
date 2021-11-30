package com.trummy.symptomsservice.dto;


import com.trummy.symptomsservice.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SymptomDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @Enumerated
    private Level intensity;
}
