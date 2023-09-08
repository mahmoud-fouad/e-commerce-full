package com.mfouad.dto;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ProductsAvailableRequest {
    List<ProductCategoryDTO> data;
    
}
