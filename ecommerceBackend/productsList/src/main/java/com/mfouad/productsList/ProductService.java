package com.mfouad.productsList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mfouad.ecommerce.Exceptions.EcommerceException;

@Service
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
public List<ProductModel> getAllProducts() {
    return repo.findAll();
}

private ProductModel getProduct(String  prodUniName){
    return repo.findByProdUniName("prodUniName").orElseThrow(()->new EcommerceException("can not find product by this id"));
}

}