package com.mfouad.ecommerce.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mfouad.ecommerce.Store.IStoreDataStore;
import com.mfouad.ecommerce.Store.StoreModel;
import com.mfouad.ecommerce.Store.StoreRepo;
import com.mfouad.ecommerce.Store.StoreService;

@SpringBootTest
public class StoreServiceTest {
    
    @Mock
    private StoreRepo storeRepo;

    @Autowired
    IStoreDataStore dataStore;

    @Autowired
    StoreService storeService;

    @BeforeEach
    void setMockOutput() {
       
    }


    @Test
public void additOnRedis(){

    storeService.add(StoreModel.builder().id(1)
    .address("first address").name("first name").build());

    assertNotNull (dataStore.get(1));

    assertEquals(dataStore.get(1).getAddress(),"first address");


}
@Test
public void notExistInRedis(){

    storeService.add(StoreModel.builder().id(1)
    .address("first address").name("first name").build());

    assertNull (dataStore.get(2));

}
    
}
