package com.trummy.symptomsservice.controller;

import com.trummy.symptomsservice.dao.Symptom;
import com.trummy.symptomsservice.dto.SymptomDTO;
import com.trummy.symptomsservice.service.SymptomService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/symptom")
public class SymptomController {

    private final SymptomService symptomService;

    public SymptomController(SymptomService symptomService) {
        this.symptomService = symptomService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Symptom> allSymptoms() {
        return symptomService.findAllSymptoms();
    }

    @GetMapping("/user/{userId}")
    @ResponseStatus
    public List<Symptom> allSymptomsById(@PathVariable("userId") Long userId) {
        return symptomService.findAllSymptomsById(userId);
    }

    @GetMapping("/{symptomId}")
    @ResponseStatus(HttpStatus.OK)
    public Symptom findSymptom(@PathVariable("symptomId") Long symptomId) {
        return symptomService.findSymptomById(symptomId);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Symptom updateSymptom(@RequestBody Symptom updateSymptom) {
        return symptomService.updateSymptom(updateSymptom);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Symptom saveSymptom(@RequestBody @Valid SymptomDTO newSymptom) {
        return symptomService.saveSymptom(newSymptom);
    }

    @DeleteMapping("/{symptomId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("symptomId") Long symptomId) {
        symptomService.delete(symptomId);
    }
}
