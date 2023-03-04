package com.mfouad.ecommerce.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<List<CategoryModel>> getAll(){

        return ResponseEntity.ok(categoryService.getAll());
    }

    @PutMapping
    public ResponseEntity<Void> create(@Valid @RequestBody CategoryModel cat){
        categoryService.create(cat);
        return ResponseEntity.ok().build();
    }
    
}
