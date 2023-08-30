package com.mfouad.productsList;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



public interface ProductRepo  extends JpaRepository<ProductModel, Long>{

     @Query("SELECT e FROM ProductModel e WHERE e.prodUniName = :prodUniName ")
     Optional<ProductModel>  findByProdUniName(@Param ("prodUniName") String refId);
    
}