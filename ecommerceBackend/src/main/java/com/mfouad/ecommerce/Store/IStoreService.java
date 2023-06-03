package com.mfouad.ecommerce.Store;

public interface IStoreService {

    void add(StoreModel modle);
    StoreModel get(long id);
    void update(StoreModel modle);
    
}
