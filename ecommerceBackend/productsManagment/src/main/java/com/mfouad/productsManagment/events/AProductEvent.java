package com.mfouad.productsManagment.events;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.springframework.context.ApplicationEvent;

public abstract class AProductEvent extends ApplicationEvent implements Serializable{
     public final UUID id = UUID.randomUUID();
    public final Date created = new Date();


public AProductEvent(Object source){
    super(source);
}

}
