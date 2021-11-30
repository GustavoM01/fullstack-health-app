package com.trummy.gatewayservice;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CloudGatewayConfig {

    @Bean
    public RouteLocator router(RouteLocatorBuilder builder) {
        return
                builder
                    .routes()

                        .route(p -> p.path("/user/**")
                        .uri("lb://user-service"))
                        .route(p -> p.path("/meal/**")
                        .uri("lb://meal-service"))
                        .route(p -> p.path("/ingredient/**")
                        .uri("lb://ingredient-service"))
                        .route(p -> p.path("/symptom/**")
                        .uri("lb://symptom-service"))

                    .build();
    }
}
