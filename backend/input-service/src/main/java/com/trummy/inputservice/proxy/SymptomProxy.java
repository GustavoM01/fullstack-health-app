package com.trummy.inputservice.proxy;

import com.trummy.inputservice.dto.SymptomDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("symptom-service")
public interface SymptomProxy {

    @PostMapping("/symptom")
    SymptomDTO addNewSymptom(SymptomDTO newSymptom);
}
