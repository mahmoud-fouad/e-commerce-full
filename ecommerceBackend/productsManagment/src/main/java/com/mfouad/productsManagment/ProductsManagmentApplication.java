package com.mfouad.productsManagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = "com.mfouad")
public class ProductsManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsManagmentApplication.class, args);
	}

	@Bean("rawRestTemplate")
	@LoadBalanced
public RestTemplate restTemplate() {
    return new RestTemplate();
}

}
