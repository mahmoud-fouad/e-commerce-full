package com.mfouad.productsList;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;




public interface ProductRepo  extends JpaRepository<ProductModel, Long>{

     @Query("SELECT e FROM ProductModel e WHERE e.prodUniName = :prodUniName ")
     Optional<ProductModel>  findByProdUniName(@Param ("prodUniName") String refId);

     @Query("SELECT e FROM ProductModel e WHERE e.price < :price ")
     List<ProductModel> getProductsByPrice(@Param("price") double price);

      @Query("SELECT e FROM ProductModel e WHERE e.manufacturer = :manufacturer ")
     List<ProductModel> getProductsByManufacturer(@Param("manufacturer") String manufacturer);
    
}