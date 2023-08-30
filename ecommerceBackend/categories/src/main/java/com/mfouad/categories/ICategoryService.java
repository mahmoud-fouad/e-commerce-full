package com.mfouad.categories;
import java.util.List;


public interface ICategoryService {
    
public List <CategoryModel> getAll();
public void create(CategoryModel category);
public CategoryModel getCategoryDetails(long id);
public void update(CategoryModel category);
public void delete(long id);
    
}
