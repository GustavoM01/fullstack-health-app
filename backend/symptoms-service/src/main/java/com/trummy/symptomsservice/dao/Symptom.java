package com.trummy.symptomsservice.dao;

import com.trummy.symptomsservice.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Symptom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Enumerated
    private Level intensity;

    public Symptom(String name, String description, Level intensity) {
        this.name = name;
        this.description = description;
        this.intensity = intensity;
    }
}