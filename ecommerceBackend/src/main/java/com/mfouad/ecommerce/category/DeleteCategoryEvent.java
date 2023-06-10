package com.mfouad.ecommerce.category;

import org.springframework.context.ApplicationEvent;

public class DeleteCategoryEvent extends ApplicationEvent {
    
    public DeleteCategoryEvent(Object source) {
        super(source);
       
    }

    
}
