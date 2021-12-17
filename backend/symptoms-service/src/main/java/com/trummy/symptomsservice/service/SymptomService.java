package com.trummy.symptomsservice.service;

import com.trummy.symptomsservice.dao.Symptom;
import com.trummy.symptomsservice.dto.SymptomDTO;
import com.trummy.symptomsservice.enums.Level;
import com.trummy.symptomsservice.enums.Type;
import com.trummy.symptomsservice.repository.SymptomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public List<Symptom> findAllSymptomsById(Long userId) {
        return symptomRepository.findByUserId(userId);
    }

    public Symptom findSymptomById(Long symptomId) {
        Optional<Symptom> foundSymptom = symptomRepository.findById(symptomId);
        return foundSymptom.orElse(null);
    }

    public Symptom updateSymptom(Symptom updateSymptom) {
        Optional<Symptom> foundSymptom = symptomRepository.findById(updateSymptom.getId());

        if (foundSymptom.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no symptom by that id");
        return symptomRepository.save(updateSymptom);

    }

    public Symptom saveSymptom(SymptomDTO newSymptom) {
        Symptom symptom =
                new Symptom(
                   newSymptom.getUserId(),
                   Type.valueOf(newSymptom.getName()),
                   newSymptom.getDescription(),
                   Level.valueOf(newSymptom.getIntensity()),
                   newSymptom.getTimeOfSymptom());

        return symptomRepository.save(symptom);
    }

    public void delete(Long symptomId) {
        symptomRepository.deleteById(symptomId);
    }
}
