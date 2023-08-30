package com.mfouad.productsManagment.events;

import com.mfouad.productsManagment.ProductDTO;



public class CreateProductEvent extends AProductEvent{
   
    ProductDTO dto;

public CreateProductEvent(Object source){
    super(source);
this.dto=(ProductDTO) source;

}

public ProductDTO getDto() {
    return dto;
}

}
