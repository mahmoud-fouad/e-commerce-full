package com.mfouad.productsManagment;


import org.springframework.stereotype.Service;
import com.mfouad.productsManagment.commands.CreateProductCommand;
import com.mfouad.productsManagment.commands.ProductAggregate;


@Service
public class ProductService implements IProductService{
    
ProductAggregate aggregate;

public ProductService(ProductAggregate aggregate){
   this.aggregate=aggregate;
}




@Override
public void add(ProductDTO dto) {
    
   aggregate.fireِCommand(new CreateProductCommand(dto));
    
}

@Override
public void update(ProductDTO dto) {
//    ProductModel model= getProduct(dto.getId());
   
//    model.setCategoryID(dto.getCatID());
//    model.setDescription(dto.getDescription());
//    model.setManufacturer(dto.getManufacturer());
//    model.setName(dto.getName());
    
//    repo.save(model);
}

// private ProductModel getProduct(long id){
//     return repo.findById(id).orElseThrow(()->new EcommerceException("can not find product by this id"));
// }

}