package com.mfouad.ecommerce.Store;



import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.mfouad.ecommerce.Redis.RedisConnectin;

import redis.clients.jedis.Jedis;

@Component
public class RedisStoreData implements IStoreDataStore , ApplicationListener<StoreEvent>{
private final String  key ="store:";
    @Override
    public StoreModel get(long id) {
        
        Jedis jedis=RedisConnectin.getJedisResource();
if (!jedis.hexists(key+id, "name"))
return null;

        StoreModel memoryStore = StoreModel.builder()
			.name(jedis.hget(key+id, "name"))
            .address(jedis.hget(key+id, "address"))
            .id(id)
            .build();

            return memoryStore;
        
    }


    @Override
    public void add(StoreModel model) {
        Jedis jedis=RedisConnectin.getJedisResource();
        jedis.hset(key+model.id, "name", model.getName());
        jedis.hset(key+model.id, "address", model.getAddress());
    }


    @Override
    public void onApplicationEvent(StoreEvent event) {
        add((StoreModel)event.getSource() );
    }
    
}
