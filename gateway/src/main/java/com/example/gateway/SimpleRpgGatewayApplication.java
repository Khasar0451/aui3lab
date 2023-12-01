package com.example.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class
SimpleRpgGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleRpgGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(
            RouteLocatorBuilder builder,
            @Value("${drg.weapon.url}") String weaponUrl,
            @Value("${drg.dwarf.url}") String dwarfUrl,
            @Value("${drg.gateway.host}") String host
    ) {
        return builder
                .routes()
                .route("dwarves", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/drg/dwarves/{uuid}",
                                "/drg/dwarves"
                        )
                        .uri(dwarfUrl)
                )
                .route("weapons", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/drg/weapons",
                                "/drg/weapons/**",
                                "/drg/dwarves/{uuid}/weapons",
                                "/drg/dwarves/{uuid}/weapons/**"
                        )
                        .uri(weaponUrl)
                )
                .build();
    }
}
