package com.mfouad.inventory;

import java.util.List;

import com.mfouad.dto.ProductInvDto;

public interface IInventoryServices {

    void add(InvProduct model);

    void increaseCount(String productUniName);

    void decreaseCount(String productUniName);

    boolean isProdAvailableInInv(String productUniName);

    List<ProductInvDto>  isProdsAvailableInInv(List<String> productsUniName);

    InvProduct updateProductCount(String productUniName,int count);
    
}
