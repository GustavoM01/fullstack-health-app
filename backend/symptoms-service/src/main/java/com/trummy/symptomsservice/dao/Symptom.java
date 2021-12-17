package com.trummy.symptomsservice.dao;

import com.trummy.symptomsservice.enums.Level;
import com.trummy.symptomsservice.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Symptom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @Enumerated(EnumType.STRING)
    private Type name;

    private String description;

    @Enumerated(EnumType.STRING)
    private Level intensity;

    private Date timeOfSymptom;

    public Symptom(Long userId, Type name, String description, Level intensity, Date timeOfSymptom) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.intensity = intensity;
        this.timeOfSymptom = timeOfSymptom;
    }
}
