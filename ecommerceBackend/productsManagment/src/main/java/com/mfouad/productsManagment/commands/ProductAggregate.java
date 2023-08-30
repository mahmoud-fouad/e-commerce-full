package com.mfouad.productsManagment.commands;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.mfouad.productsManagment.ProductModel;
import com.mfouad.productsManagment.ProductRepo;
import com.mfouad.productsManagment.events.CreateProductEvent;


@Component
public class ProductAggregate {

ProductRepo repo;

@Autowired
	ApplicationEventPublisher applicationEventPublisher;

   public ProductAggregate(ProductRepo repo){
    this.repo=repo;

    }   

    public void fireِCommand(CreateProductCommand command){
        ProductModel modle = ProductModel.builder()
        .description(command.getDto().getDescription())
        .manufacturer(command.getDto().getManufacturer())
        .name(command.getDto().getName())
        .categoryID(command.getDto().getCatID())
        .build();
       modle=repo.save(modle);
       command.getDto().setId(modle.getId());
applicationEventPublisher.publishEvent(new CreateProductEvent(command.getDto()));
    }

    
}
