package com.mfouad.productsList;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mfouad.ecommerce.Exceptions.EcommerceException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService implements IProductService{
    
ProductRepo repo;


ProductService(ProductRepo repo){
this.repo  =repo;
}

@Override
public void add(ProductModel modle) {
   repo.save(modle);
    
}

@Override
public void update(ProductDTO dto) {
  
}


@Override
public List<ProductModel> getLowPriceProducts(){

List<ProductModel> data=    repo.getProductsByPrice(25);

log.info("retrive products with prices lower that {} and size is {}", 20,data.size());

return data;
}

@Override
public List<ProductModel> getProductsByManf (String input){
    
   return repo.getProductsByManufacturer(input);
}


@Override
public List<ProductModel> getAllProducts() {
    return repo.findAll();
}

private ProductModel getProduct(String  prodUniName){
    return repo.findByProdUniName("prodUniName").orElseThrow(()->new EcommerceException("can not find product by this id"));
}

}