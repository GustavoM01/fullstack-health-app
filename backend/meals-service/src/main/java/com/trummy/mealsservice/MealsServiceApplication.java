package com.trummy.mealsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class MealsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MealsServiceApplication.class, args);
	}

}
