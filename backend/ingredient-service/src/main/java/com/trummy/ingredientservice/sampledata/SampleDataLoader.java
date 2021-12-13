package com.trummy.ingredientservice.sampledata;

import com.github.javafaker.Faker;
import com.trummy.ingredientservice.dao.Ingredient;
import com.trummy.ingredientservice.dto.IngredientDTO;
import com.trummy.ingredientservice.repository.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private final IngredientRepository ingredientRepository;
    private final Faker faker;

    public SampleDataLoader(IngredientRepository ingredientRepository, Faker faker) {
        this.ingredientRepository = ingredientRepository;
        this.faker = faker;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Ingredient> ingredientData = IntStream.rangeClosed(1, 50)
                .mapToObj(i -> new Ingredient(
                        faker.food().ingredient()
                )).collect(Collectors.toList());

        ingredientRepository.saveAll(ingredientData);
    }
}
