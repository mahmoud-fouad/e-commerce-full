package com.mfouad.categories;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class NewCategoryDTO {
    
       
    private @NotBlank String desc;
    private String imageUrl;
    private @NotBlank String name;
}