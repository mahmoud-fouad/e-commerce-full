package com.mfouad.productsManagment.events;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;


public class EventStore {
    
     private Map<String, List<AProductEvent>> store = new Hashtable<>();


     public void addEvent(String productUniName,AProductEvent event ){
        synchronized(store){
if(store.containsKey(productUniName)){
    store.get(productUniName).add(event);
}
else{
   List<AProductEvent> events= new ArrayList<>();
   events.add(event);
        store.put(productUniName, events);
}
     }
     }
}
