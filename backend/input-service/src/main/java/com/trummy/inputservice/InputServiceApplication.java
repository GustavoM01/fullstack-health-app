package com.trummy.inputservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class InputServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InputServiceApplication.class, args);
	}

}

// 1. create a new user X
// 2. input a meal x
// 3. add ingredients to meal x
// 4. add symptoms X
