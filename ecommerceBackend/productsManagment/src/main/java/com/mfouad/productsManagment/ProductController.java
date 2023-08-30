package com.mfouad.productsManagment;


import java.util.List;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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


    @PutMapping
    public ResponseEntity<Void> create(@Valid @RequestBody ProductDTO dto){
        productService.add(dto);
        return ResponseEntity.ok().build();
    }

    
}