package com.trummy.ingredientservice.sampledata;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleDataConfig {

    @Bean
    public Faker faker() {
        return new Faker();
    }
}
