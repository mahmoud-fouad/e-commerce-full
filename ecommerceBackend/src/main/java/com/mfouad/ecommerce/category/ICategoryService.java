package com.mfouad.ecommerce.category;
import java.util.List;

public interface ICategoryService {
    
public List <CategoryModel> getAll();
public void create(CategoryModel category);

}
