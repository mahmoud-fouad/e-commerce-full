package com.mfouad.ecommerce.Products;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("products")
@Slf4j
public class ProductController {

    @Autowired
    IProductService productService;

    @PutMapping
    public ResponseEntity<Void> create(@Valid @RequestBody ProductDTO dto){
        productService.add(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ProductModel>> getAll(){
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable (name = "id") long id  , @Valid @RequestBody ProductDTO dto){
        
        productService.update(UpdateProductDTO.builder().dto(dto).id(id).build());
        return ResponseEntity.ok().build();
    }
    
}
