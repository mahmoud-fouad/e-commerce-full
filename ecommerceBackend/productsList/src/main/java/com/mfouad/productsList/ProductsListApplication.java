package com.mfouad.productsList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mfouad.dto.CategoryModel;

@SpringBootApplication
public class ProductsListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsListApplication.class, args);
	}

	@Bean
    public CommandLineRunner demoData(ProductRepo repo) {
        return args -> { 

            repo.save(ProductModel.builder().categoryDesc("first category").categoryImage("http://localhost")
			
			.categoryName("first category")
			// .categoryID(1L)
			.description("product desc")
			.id(1)
			.manufacturer("manf")
			// .price(15)
			 .build());
			//repo.save(CategoryModel.builder().desc("second category").imageUrl("http://localhost").name("second category").build());

        };
	
    }

}
