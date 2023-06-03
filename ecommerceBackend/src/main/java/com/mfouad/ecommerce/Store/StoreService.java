package com.mfouad.ecommerce.Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class StoreService implements IStoreService{

    IStoreDataStore dataStore;
    StoreRepo storeRepo;

    @Autowired
	ApplicationEventPublisher applicationEventPublisher;

StoreService(IStoreDataStore dataStore,StoreRepo storeRepo){
    this.dataStore =dataStore;
    this.storeRepo = storeRepo;
}

    @Override
    public void add(StoreModel modle) {
        raiseAddStoreEvent(modle); 
    }

    @Override
    public StoreModel get(long id) {
       return dataStore.get(id);
    }

    @Override
    public void update(StoreModel modle) {
        
    }

    //@Async
	public void raiseAddStoreEvent(StoreModel modle){
		applicationEventPublisher.publishEvent(new StoreEvent(modle));
		
	}

    
    
}
