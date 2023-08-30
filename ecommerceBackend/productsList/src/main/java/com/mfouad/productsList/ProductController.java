package com.mfouad.productsList;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping()
@Slf4j
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductModel>> getAll(){
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    
}