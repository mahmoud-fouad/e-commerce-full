package com.mfouad.productsList;





import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.mfouad.dto.ManfProductsInput;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ProductQraphController {

IProductService productService;
   public ProductQraphController(IProductService productService){
    this.productService = productService;
   }
    
    @QueryMapping 
    public List<ProductModel> lowPrice() {
        log.info("in ProductQraphController");
        return productService.getLowPriceProducts();
    }

    // use schema query to map ManfProductsInput custom input
    @QueryMapping
    public List<ProductModel> manufacturerProducts(@Argument("manf") String input ){
         log.info("in getManfProducts and has request with argument {}",input);
     return productService.getProductsByManf(input)  ;
    }

  


}
