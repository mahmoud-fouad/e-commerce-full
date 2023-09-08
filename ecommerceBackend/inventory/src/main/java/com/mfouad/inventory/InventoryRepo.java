package com.mfouad.inventory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InventoryRepo  extends JpaRepository<InvProduct , Long>{
   
     @Query("SELECT e FROM InvProduct e WHERE e.prodUniName = :prodUniName ")
     Optional<InvProduct>  findByProdUniName(@Param ("prodUniName") String refId);

     @Query("SELECT count(e) FROM InvProduct e WHERE e.prodUniName = :prodUniName ")
     Integer  prodUniNameCount(@Param ("prodUniName") String refId);

      @Query("SELECT e.prodUniName, e.invCount FROM InvProduct e WHERE e.prodUniName in :prodsUniName ")
     List<Object[]>  prodsUniNameCount(@Param ("prodsUniName") List<String> prodsUniName);

}
