package com.mfouad.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import lombok.extern.slf4j.Slf4j;

import java.util.List;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
//@RequestMapping("categories")
@Slf4j
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<CategoryModel>> getAll(){
          log.info("get all categories ");
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryModel> getCategoryDetails(@PathVariable (name = "id") long id ){
        log.info("get details for category "+id);
        CategoryModel res = categoryService.getCategoryDetails(id);
        log.info(res.toString());

        return ResponseEntity.ok(res);
    }

    @PutMapping
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody NewCategoryDTO cat){
        categoryService.create(CategoryModel.builder().desc(cat.getDesc()).imageUrl(cat.getImageUrl()).name(cat.getName()).build());
        return ResponseEntity.ok(ApiResponse.builder().success(true).build() );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable (name = "id") long id ,@RequestBody UpdateCategoryDescriptionOrImage cat){
        categoryService.update(CategoryModel.builder().id(id).desc(cat.getDesc()).imageUrl(cat.getImageUrl()).build());
        return ResponseEntity.ok(ApiResponse.builder().success(true).build() );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable (name = "id") long id){
        categoryService.delete(id);
        return ResponseEntity.ok(ApiResponse.builder().success(true).build() );
    } 
}
