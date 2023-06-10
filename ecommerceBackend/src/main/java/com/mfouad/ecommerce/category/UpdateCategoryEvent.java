package com.mfouad.ecommerce.category;

import org.springframework.context.ApplicationEvent;

public class UpdateCategoryEvent extends ApplicationEvent {
    
    public UpdateCategoryEvent(Object source) {
        super(source);
       
    }

    
}
