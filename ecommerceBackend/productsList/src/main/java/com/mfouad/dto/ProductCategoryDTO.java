package com.mfouad.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Data
@ToString
@NoArgsConstructor
public class ProductCategoryDTO implements Serializable{
    
    long id;
    String name;
    String description;
    String url;
    String manufacturer;
    long catID;
    String catName;
    String catDesc;
    String catImage;
    String prodUniName;
}
