package com.mfouad.productsManagment.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mfouad.configurations.KafkaConfiguration;
import com.mfouad.dto.CategoryModel;
import com.mfouad.dto.ProductCategoryDTO;
import com.mfouad.productsManagment.ProductDTO;

import org.springframework.messaging.Message;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CreateProductEventListener implements ApplicationListener<CreateProductEvent>{

@Autowired
@Qualifier("rawRestTemplate")
RestTemplate rawRestTemplate;

@Autowired
KafkaConfiguration kafkaConf;

@Autowired
private KafkaTemplate<String, ProductCategoryDTO> template;

    @Override
    public void onApplicationEvent(CreateProductEvent event) {
        log.info("-- in CreateProductEventListener");
       ProductDTO dto = (ProductDTO) event.getSource();
       
       ResponseEntity<CategoryModel> categoryDetails 
       = rawRestTemplate.exchange("http://CATEGORIES-SERVICES/"+dto.getCatID(),HttpMethod.GET,null,CategoryModel.class);
       log.info("get details "+categoryDetails.getBody().getName());
       sendStringMessage(dto,categoryDetails.getBody());

    }

    private void sendStringMessage(ProductDTO product,CategoryModel category){
		
        ProductCategoryDTO dto = ProductCategoryDTO.builder()
        .catDesc(category.getDesc())
        .catID(category.getId())
        .catImage(category.getImageUrl())
        .catName(category.getName())
        .description(product.getDescription())
        .manufacturer(product.getManufacturer())
        .name(product.getName())
        .prodUniName(product.getProdUniName())
        .price(product.getPrice())
        .id(product.getId())
        .build();

		log.info("----------- send messag {} to topic {}",dto,kafkaConf.getName());
		
		Message<ProductCategoryDTO> sendMessage = MessageBuilder.withPayload(dto)
		.setHeader(KafkaHeaders.TOPIC, kafkaConf.getName())
        .setHeader(KafkaHeaders.GROUP_ID, "productsGroup")
		.build();
		template.send(sendMessage);
	}
    
}
