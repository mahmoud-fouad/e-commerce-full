package com.mfouad.ecommerce.category;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService{

    
    CategoryRepo categoryRepo;

    public CategoryService( CategoryRepo categoryRepo){
        this.categoryRepo=categoryRepo;
    }

    @Override
    public void create(CategoryModel category){
        categoryRepo.save(category);
    }

    public List<CategoryModel> getAll(){
        return categoryRepo.findAll();
    }

    @Override
    public CategoryModel getCategoryDetails(long id) {
        return categoryRepo.findById(id).get();
        
    }

    
    
   

}
