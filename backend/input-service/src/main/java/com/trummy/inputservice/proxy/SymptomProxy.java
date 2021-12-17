package com.trummy.inputservice.proxy;

import com.trummy.inputservice.dto.SymptomDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("symptom-service")
public interface SymptomProxy {

    @GetMapping("/symptom")
    List<SymptomDTO> findAll();

    @GetMapping("/symptom/user/{userId}")
    List<SymptomDTO> findAllByUser(@PathVariable Long userId);

    @PutMapping("/symptom")
    SymptomDTO updateSymptom(@RequestBody SymptomDTO updateSympom);

    @PostMapping("/symptom")
    SymptomDTO addNewSymptom(SymptomDTO newSymptom);

    @DeleteMapping("/symptom/{symptomId}")
    void delete(@PathVariable Long symptomId);
}
