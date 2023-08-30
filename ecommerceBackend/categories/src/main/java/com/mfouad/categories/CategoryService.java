package com.mfouad.categories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import org.springframework.stereotype.Service;

import com.mfouad.ecommerce.Exceptions.EcommerceException;

@Service
public class CategoryService implements ICategoryService{

    
    CategoryRepo categoryRepo;
    
    @Autowired
	ApplicationEventPublisher applicationEventPublisher;

    public CategoryService( CategoryRepo categoryRepo){
        this.categoryRepo=categoryRepo;
    }

    @Override
    public void create(CategoryModel category){
        //CategoryModel cateDb= 
        categoryRepo.save(category);
        // raiseAddCategory(cateDb);
    }

    // @Async
    // private void raiseAddCategory(CategoryModel cateDb){
    //     applicationEventPublisher.publishEvent(new AddCategoryEvent(cateDb));
    // }

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
            // raiseDeleteCategory(id);   
        } catch (Exception e) {
            throw new EcommerceException("can not find category with this id");
        }

        
    }

    // @Async
    // private void raiseDeleteCategory(long id){
    //     applicationEventPublisher.publishEvent(new DeleteCategoryEvent(id));
    // }

    private CategoryModel getCategory(long id){

        return categoryRepo.findById(id).orElseThrow(()->new EcommerceException("can not find category by this id"));
    }

}
