package com.mfouad.productsList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    long id;
    String name;
    String description;
    String url;
    String manufacturer;
    long catID;
    String catName;
    String catDesc;
    String catImage;

}
