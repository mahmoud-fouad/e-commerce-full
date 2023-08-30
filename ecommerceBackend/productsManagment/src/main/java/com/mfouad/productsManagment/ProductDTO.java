package com.mfouad.productsManagment;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    double price;

    @JsonIgnore
    public String getProdUniName(){
    return manufacturer+"-"+name+new Date().getTime();


}

}
