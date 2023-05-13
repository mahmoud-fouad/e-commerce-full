package com.mfouad.ecommerce.Products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    String name;
    String description;
    String url;
    String manufacturer;
    long catID;

}
