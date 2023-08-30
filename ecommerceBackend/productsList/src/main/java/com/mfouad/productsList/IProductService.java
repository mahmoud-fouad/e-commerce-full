package com.mfouad.productsList;

public interface IProductService {

    java.util.List<ProductModel> getAllProducts();
     void add(ProductModel model);
    void update(ProductDTO dto);

    
}
