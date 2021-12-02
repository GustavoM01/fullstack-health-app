package com.trummy.inputservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("ingredient-service")
public interface IngredientProxy {
}
