package com.trummy.mealsservice.sampledata;

import com.github.javafaker.Faker;
import com.trummy.mealsservice.dao.Meal;
import com.trummy.mealsservice.repository.MealRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private MealRepository mealRepository;
    private Faker faker;

    public SampleDataLoader(MealRepository mealRepository, Faker faker) {
        this.mealRepository = mealRepository;
        this.faker = faker;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Long> demoIngredients = List.of(1L, 2L, 3L, 4L, 5L);

        Date earlierDate = new Date(new Date().getTime() - 1000);

        List<Meal> mealList = IntStream.rangeClosed(1, 20)
                .mapToObj(i -> new Meal(
                        faker.food().dish(),
                        demoIngredients,
                        faker.date().past(90, TimeUnit.DAYS)
                )).collect(Collectors.toList());

        mealRepository.saveAll(mealList);

    }
}
