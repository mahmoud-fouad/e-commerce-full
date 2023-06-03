package com.mfouad.ecommerce.Redis;



import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisConnectin {

   

  static JedisPool pool =new JedisPool("127.0.0.1", 6379);
  
public static Jedis getJedisResource(){
   return pool.getResource();

}

    
}
