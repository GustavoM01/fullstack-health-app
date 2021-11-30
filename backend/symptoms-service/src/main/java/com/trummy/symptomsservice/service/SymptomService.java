package com.trummy.symptomsservice.service;

import com.trummy.symptomsservice.dao.Symptom;
import com.trummy.symptomsservice.dto.SymptomDTO;
import com.trummy.symptomsservice.repository.SymptomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SymptomService {

    private final SymptomRepository symptomRepository;

    public SymptomService(SymptomRepository symptomRepository) {
        this.symptomRepository = symptomRepository;
    }

    public List<Symptom> findAllSymptoms() {
        return symptomRepository.findAll();
    }

    public Symptom findSymptomById(Long symptomId) {
        Optional<Symptom> foundSymptom = symptomRepository.findById(symptomId);
        return foundSymptom.orElse(null);
    }

    public Symptom saveSymptom(SymptomDTO newSymptom) {
        Symptom symptom =
                new Symptom(
                   newSymptom.getName(),
                   newSymptom.getDescription(),
                   newSymptom.getIntensity());

        return symptomRepository.save(symptom);
    }
}
