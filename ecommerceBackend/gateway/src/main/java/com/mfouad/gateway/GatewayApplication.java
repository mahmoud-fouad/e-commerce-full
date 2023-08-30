package com.mfouad.gateway;

import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;


@SpringBootApplication
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	//  @Bean
    public CorsWebFilter corsWebFilter() {

        final CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Collections.singletonList("*"));
        corsConfig.setMaxAge(3600L);
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST","PUT"));
        corsConfig.addAllowedHeader("*");

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }  

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {

		
				return builder.routes()
        .route(p -> p
            .path("/categories**")
            .filters(f -> f
			.rewritePath("/categories", "/")
			.circuitBreaker(config -> config
			.setName("mycmd")
					.setFallbackUri("forward:/fallback") 
					.setResumeWithoutError(true)
					)
			)
            .uri("lb://CATEGORIES-SERVICES"))
			
			.route(p -> p
            .path("/products**")
			 .and()
			 .method(HttpMethod.GET)
            .filters(f -> f
			.rewritePath("/products", "/")
			.circuitBreaker(config -> config
			.setName("mycmd")
					.setFallbackUri("forward:/fallback") )
			)
            .uri("lb://PRODUCTSLIST"))
			

			.route(p -> p
            .path("/products**")
			.and()
			.method(HttpMethod.PUT)
            .filters(f -> f
			.rewritePath("/products", "/")
			.circuitBreaker(config -> config
			.setName("mycmd")
					.setFallbackUri("forward:/fallback") )
			)
            .uri("lb://PRODUCTSMANAGMENT"))
			
        .build();

	}

	@RequestMapping("/fallback")
	public Mono<String> fallback() {
		return Mono.just("fallback");
	}

}
