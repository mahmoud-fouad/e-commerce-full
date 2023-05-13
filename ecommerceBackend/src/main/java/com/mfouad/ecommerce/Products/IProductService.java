package com.mfouad.ecommerce.Products;


public interface IProductService {

    void add(ProductDTO dto);

    void update(UpdateProductDTO dto);

    java.util.List<ProductModel> getAllProducts();


    
}
