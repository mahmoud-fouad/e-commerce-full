package com.mfouad.productsList.events;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;


import com.mfouad.dto.ProductCategoryDTO;
import com.mfouad.productsList.IProductService;
import com.mfouad.productsList.ProductModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AppProductListener {

	@Autowired
	IProductService productService;
	


    @KafkaListener(topics={"${topic.name}"},groupId ="productsGroup" )
	public void consume(ProductCategoryDTO addProductDTO){
		
		log.info("in {} --------------------",this.getClass());
		log.info("receive {}",addProductDTO);
		ProductModel model =ProductModel.builder()
		.categoryDesc(addProductDTO.getCatDesc())
		.categoryID(addProductDTO.getCatID())
		.categoryImage(addProductDTO.getCatImage())
		.manufacturer(addProductDTO.getManufacturer())
		.name(addProductDTO.getName())
		.prodUniName(addProductDTO.getProdUniName())
		.url(addProductDTO.getUrl())
		.price(addProductDTO.getPrice())
		.build();
		productService.add(model);

		
	}

	
    
}
