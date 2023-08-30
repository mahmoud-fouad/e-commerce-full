package com.mfouad.productsManagment;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductWriteRepository {
 private Map<String, ProductModel> store = new HashMap<>();
    
}
