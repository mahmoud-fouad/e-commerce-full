package com.mfouad.ecommerce.Store;

public interface IStoreDataStore {
    
StoreModel get(long id);

void add(StoreModel model);

}
