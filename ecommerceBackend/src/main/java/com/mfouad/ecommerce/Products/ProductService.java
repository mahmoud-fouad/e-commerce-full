package com.mfouad.ecommerce.Products;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mfouad.ecommerce.Exceptions.EcommerceException;

@Service
public class ProductService implements IProductService{
    
ProductRepo repo;

ICategoriesStore categoriesStore;

ProductService(ProductRepo repo,ICategoriesStore categoriesStore){
this.repo  =repo;
this.categoriesStore = categoriesStore;
}

@Override
public void add(ProductDTO dto) {
    
   ProductModel modle = ProductModel.builder()
   .description(dto.getDescription())
   .manufacturer(dto.getManufacturer())
   .name(dto.getName())
   .categoryID(dto.getCatID())
   .build();
   repo.save(modle);
    
}

@Override
public void update(UpdateProductDTO dto) {
   ProductModel model= getProduct(dto.getId());
   
   model.setCategoryID(dto.getDto().getCatID());
   model.setDescription(dto.getDto().getDescription());
   model.setManufacturer(dto.getDto().getManufacturer());
   model.setName(dto.getDto().getName());
    
   repo.save(model);
}

@Override
public List<ProductModel> getAllProducts() {
    return repo.findAll();
}

private ProductModel getProduct(long id){
    return repo.findById(id).orElseThrow(()->new EcommerceException("can not find product by this id"));
}


}
