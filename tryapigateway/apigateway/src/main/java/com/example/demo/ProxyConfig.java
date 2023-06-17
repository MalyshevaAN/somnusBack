package com.example.demo;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class ProxyConfig {
    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("random_animal_route",
                        route -> route.path("/random/**")
                                .and().method(HttpMethod.GET)
                                .filters(filter -> filter.stripPrefix(1))
                .uri("lb://random"))
                .route("zoo_route", route -> route.path("/zoo/**")
                .filters(filter -> filter.stripPrefix(1)).uri("lb://zoo"))
                        .build();
    }
}
