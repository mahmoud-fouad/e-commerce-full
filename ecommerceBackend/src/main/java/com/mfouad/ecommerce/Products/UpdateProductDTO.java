package com.mfouad.ecommerce.Products;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateProductDTO{
    long id;
    ProductDTO dto;

    
}
