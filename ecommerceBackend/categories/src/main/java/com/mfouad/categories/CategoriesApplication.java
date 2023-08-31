package com.mfouad.categories;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class CategoriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoriesApplication.class, args);
	}

	@Bean
    public CommandLineRunner demoData(CategoryRepo repo) {
        return args -> { 

            repo.save(CategoryModel.builder().desc("first category").imageUrl("http://localhost").name("first category").build());
			repo.save(CategoryModel.builder().desc("second category").imageUrl("http://localhost").name("second category").build());

        };
	
    }

}
