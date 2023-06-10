package com.mfouad.ecommerce.Products;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mfouad.ecommerce.category.CategoryModel;
import com.mfouad.ecommerce.category.CategoryService;
import com.mfouad.ecommerce.category.ICategoryService;

@SpringBootTest
public class ProductsServices {


    @Autowired
    ICategoriesStore store;

    @Autowired
    ICategoryService categoryService;

    @Test
    public void redistStoreImpl(){
        assertTrue(store instanceof CategoryStoreRedisImpl);
    }

    @Test
    public void categoryInStore(){
        CategoryModel m =CategoryModel.builder().desc("test").name("name").imageUrl("imageurl")
        .build();
         categoryService.create(m);

        assertTrue(store.isCategoryExist(1));
    }


    
}
