package com.mfouad.ecommerce.Products;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.mfouad.ecommerce.Redis.RedisConnectin;
import com.mfouad.ecommerce.category.CategoryModel;

import redis.clients.jedis.Jedis;

@Service("ProductsCategory")
@Primary
public class CategoryStoreRedisImpl implements ICategoriesStore{

    final String key = "category-";

    @Override
    public CategoryModel getCategoryDetails(long id) {
        throw new UnsupportedOperationException("Unimplemented method 'getCategoryDetails'");
    }

    @Override
    public boolean isCategoryExist(long id) {
        Jedis jedis= RedisConnectin.getJedisResource();
        return jedis.exists(key+id);
    }

    
    
    
}
