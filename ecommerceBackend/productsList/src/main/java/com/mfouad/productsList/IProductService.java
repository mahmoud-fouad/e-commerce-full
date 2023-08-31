package com.mfouad.productsList;
import java.util.List;



public interface IProductService {

    List<ProductModel> getAllProducts();
     void add(ProductModel model);
    void update(ProductDTO dto);

    List<ProductModel> getLowPriceProducts();
     List<ProductModel> getProductsByManf (String input);

    
}
