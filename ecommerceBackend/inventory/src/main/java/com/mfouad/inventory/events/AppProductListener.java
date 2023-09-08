package com.mfouad.inventory.events;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.annotation.KafkaListener;


import com.mfouad.dto.ProductCategoryDTO;
import com.mfouad.inventory.IInventoryServices;
import com.mfouad.inventory.InvProduct;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AppProductListener {

	@Autowired
	IInventoryServices service;
	


    @KafkaListener(topics={"${topic.name}"},groupId ="${topic.groupId}" )
	public void consume(ProductCategoryDTO addProductDTO){
		
		log.info("in {} --------------------",this.getClass());
		log.info("receive {}",addProductDTO);
		InvProduct model =InvProduct.builder()
		.categoryDesc(addProductDTO.getCatDesc())
		.categoryID(addProductDTO.getCatID())
		.categoryImage(addProductDTO.getCatImage())
		.manufacturer(addProductDTO.getManufacturer())
		.name(addProductDTO.getName())
		.prodUniName(addProductDTO.getProdUniName())
		.url(addProductDTO.getUrl())
		.price(addProductDTO.getPrice())
		.build();
		service.add(model);
	}

	
    
}
