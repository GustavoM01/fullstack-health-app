package com.trummy.symptomsservice.sampledata;

import com.trummy.symptomsservice.dao.Symptom;
import com.trummy.symptomsservice.dto.SymptomDTO;
import com.trummy.symptomsservice.enums.Level;
import com.trummy.symptomsservice.enums.Type;
import com.trummy.symptomsservice.repository.SymptomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static com.trummy.symptomsservice.enums.Type.NAUSEA;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private final SymptomRepository symptomRepository;

    public SampleDataLoader(SymptomRepository symptomRepository) {
        this.symptomRepository = symptomRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Symptom> sampleSymptoms = List.of(
                new Symptom(1L, Type.NAUSEA, "", Level.MILD, new Date()),
                new Symptom(1L, Type.HEADACHE, "", Level.SEVERE, new Date()),
                new Symptom(2L, Type.HEADACHE, "", Level.LOW, new Date())
        );

        symptomRepository.saveAll(sampleSymptoms);
    }
}
