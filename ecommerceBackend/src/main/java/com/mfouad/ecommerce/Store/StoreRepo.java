package com.mfouad.ecommerce.Store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepo  extends JpaRepository<StoreModel ,Long>{
    
}
