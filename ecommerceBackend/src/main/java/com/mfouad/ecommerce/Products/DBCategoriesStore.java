package com.mfouad.ecommerce.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfouad.ecommerce.Exceptions.EcommerceException;
import com.mfouad.ecommerce.category.CategoryModel;
import com.mfouad.ecommerce.category.CategoryRepo;

@Service
public class DBCategoriesStore implements ICategoriesStore {
    
    @Autowired
    CategoryRepo categoryRepo;


@Override
public CategoryModel getCategoryDetails(long id) {
   return categoryRepo.findById(id)
    .orElseThrow(()->new EcommerceException("can not find category by this id"));
}


@Override
public boolean isCategoryExist(long id) {
    return categoryRepo.existsById(id);
}
    
}
