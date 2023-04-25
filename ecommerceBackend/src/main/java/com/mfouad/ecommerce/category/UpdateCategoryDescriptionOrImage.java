package com.mfouad.ecommerce.category;

import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UpdateCategoryDescriptionOrImage {
    
    private String desc;
    private String imageUrl;
}
