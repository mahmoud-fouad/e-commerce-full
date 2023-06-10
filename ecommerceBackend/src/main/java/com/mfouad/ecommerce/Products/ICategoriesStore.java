package com.mfouad.ecommerce.Products;

import com.mfouad.ecommerce.category.CategoryModel;

public interface ICategoriesStore {
 
    public CategoryModel getCategoryDetails(long id);
    public boolean isCategoryExist(long id);

}
