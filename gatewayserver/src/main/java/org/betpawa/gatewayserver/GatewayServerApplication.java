package org.betpawa.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableEurekaClient
public class GatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }


    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder routeLocator) {
        return routeLocator.routes().route(p -> p.path("/betpawa/accounts/**")
                .filters(f -> f.rewritePath("/betpawa/accounts/(?<segment>.*)", ("/${segment}"))
                        .addResponseHeader("X-Response-Time", new Date().toString()))
                .uri("lb://ACCOUNTS"))

                .route(p -> p.path("/betpawa/loans/**")
                        .filters(f -> f.rewritePath("/betpawa/loans/(?<segment>.*)", ("/${segment}"))
                            .addResponseHeader("X-Response-Time", new Date().toString()))
                .uri("lb://LOANS"))

                .route(p -> p.path("/betpawa/cards/**")
                        .filters(f -> f.rewritePath("/betpawa/cards/(?<segment>.*)", ("/${segment}"))
                                .addResponseHeader("X-Response-Time", new Date().toString()))
                        .uri("lb://CARDS"))


                .build();
    }

}
