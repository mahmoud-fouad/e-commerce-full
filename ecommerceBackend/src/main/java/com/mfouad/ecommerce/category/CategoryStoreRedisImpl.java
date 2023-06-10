package com.mfouad.ecommerce.category;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import org.springframework.context.event.EventListener;

import com.mfouad.ecommerce.Redis.RedisConnectin;


import redis.clients.jedis.Jedis;

@Service
@Primary

public class CategoryStoreRedisImpl  {

    final String key = "category-";
    @EventListener ({DeleteCategoryEvent.class, AddCategoryEvent.class , UpdateCategoryEvent.class})
    public void onApplicationEvent(ApplicationEvent event) {
        
if(event instanceof AddCategoryEvent || event instanceof UpdateCategoryEvent)
        add((CategoryModel)event.getSource());

    if (event instanceof DeleteCategoryEvent)
        deleteCategory((long)event.getSource());

    }

    public void add(CategoryModel model) {
        Jedis jedis=RedisConnectin.getJedisResource();
        jedis.hset(key+model.getId(), "name", model.getName());
        jedis.hset(key+model.getId(), "desc", model.getDesc());
        jedis.hset(key+model.getId(), "image", model.getImageUrl());
    }

    public void deleteCategory(long id){
        Jedis jedis=RedisConnectin.getJedisResource();
        jedis.del(""+id); 
    }

    public void update(CategoryModel model) {
        Jedis jedis=RedisConnectin.getJedisResource();
        jedis.hset(key+model.getId(), "name", model.getName());
        jedis.hset(key+model.getId(), "desc", model.getDesc());
        jedis.hset(key+model.getId(), "image", model.getImageUrl());
    }
    
}
