package com.trummy.inputservice.proxy;

import com.trummy.inputservice.dto.IngredientReturnDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("ingredient-service")
public interface IngredientProxy {

    @GetMapping("/ingredient")
    List<IngredientReturnDTO> findAll();
}
