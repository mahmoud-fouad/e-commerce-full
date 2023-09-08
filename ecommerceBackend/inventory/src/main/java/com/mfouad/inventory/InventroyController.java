package com.mfouad.inventory;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfouad.dto.ProductAvailableResponse;
import com.mfouad.dto.ProductInvCountReq;
import com.mfouad.dto.ProductInvDto;
import com.mfouad.dto.ProductsAvailableRequest;

@RestController
@RequestMapping
public class InventroyController {
    
    @Autowired
    IInventoryServices services;

    @PatchMapping("/{productUniName}")
    public ResponseEntity<InvProduct> manageProductInvCount(@PathVariable(value = "productUniName") String productUniName, @RequestBody ProductInvCountReq req){

        return ResponseEntity.ok(services.updateProductCount(productUniName, req.getCount()));
        
    }

    @GetMapping("/{productUniName}/available")
    public ResponseEntity<ProductInvDto> isProductAvailable(@PathVariable(value = "productUniName") String productUniName){
return ResponseEntity.ok(ProductInvDto.builder().available(services.isProdAvailableInInv(productUniName)).build());
    }

    @PostMapping("/products/exist")
    public ResponseEntity<ProductAvailableResponse> areProductsAvailable(@RequestBody ProductsAvailableRequest request){
        return ResponseEntity.ok(ProductAvailableResponse.builder().data(
            services.isProdsAvailableInInv(
            request.getData().stream().map(t -> t.getProdUniName()).collect(Collectors.toList())
            )
            ).build());
    }


}
