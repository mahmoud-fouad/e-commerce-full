package com.mfouad.ecommerce.category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mfouad.ecommerce.Exceptions.EcommerceException;

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
        return getCategory(id);
        
    }

    @Override
    public void update(CategoryModel category) {
       CategoryModel model = getCategory(category.getId());
       model.setDesc(category.getDesc());
       model.setImageUrl(category.getImageUrl());
       categoryRepo.save(model);
    }

    @Override
    public void delete(long id) {
        try {
            categoryRepo.deleteById(id);    
        } catch (Exception e) {
            throw new EcommerceException("can not find category with this id");
        }
        
    }

    private CategoryModel getCategory(long id){

        return categoryRepo.findById(id).orElseThrow(()->new EcommerceException("can not find category by this id"));
    }
    
   

}
