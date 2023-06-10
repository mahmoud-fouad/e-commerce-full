package com.mfouad.ecommerce.category;

import org.springframework.context.ApplicationEvent;

public class AddCategoryEvent extends ApplicationEvent {
    
    public AddCategoryEvent(Object source) {
        super(source);
       
    }

    
}
