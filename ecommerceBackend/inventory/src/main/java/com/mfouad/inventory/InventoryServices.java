package com.mfouad.inventory;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mfouad.dto.ProductInvDto;

@Service
public class InventoryServices implements IInventoryServices{

InventoryRepo repo;

public  InventoryServices(InventoryRepo repo){
this.repo=repo;
}



    @Override
    public void add(InvProduct model) {
        model.setInvCount(1);
        repo.save(model);
    }


    @Override
    public void increaseCount(String productUniName) {
        
    }


    @Override
    public void decreaseCount(String productUniName) {
       
    }



    @Override
    public boolean isProdAvailableInInv(String productUniName) {
       return repo.prodUniNameCount(productUniName)>0;
    }



    @Override
    public InvProduct updateProductCount(String productUniName, int count) {
        
        InvProduct product = repo.findByProdUniName(productUniName).orElseThrow();
        product.setInvCount(count);
       return repo.save(product);
    }



    @Override
    public List<ProductInvDto> isProdsAvailableInInv(List<String> productsUniName) {
        List<Object[]> result = repo.prodsUniNameCount(productsUniName);
       
      return  result.stream().map( r-> ProductInvDto.builder()
      .available((int)r[1]>0)
        .prodUniName((String)r[0])
    .build() ).collect(Collectors.toList());
 
    } 

  
}
