package com.mfouad.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryModel implements Serializable{

   
    private long id;
    private  String name;
    private  String desc;
    private String imageUrl;
    
}
