package com.mfouad.ecommerce;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mfouad.ecommerce.Store.StoreModel;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@SpringBootTest

class EcommerceBackendApplicationTests {

	//@Test
	void contextLoads() throws Exception {

	}
	@Test
	void redisConnection(){
		JedisPool pool = new JedisPool("127.0.0.1", 6379);

		StoreModel sModel =StoreModel.builder().name("test").build();
        try (Jedis jedis = pool.getResource()) {
			jedis.set("store", "1");
			assertEquals("1", jedis.get("store"));
			jedis.hset("store-1", "name", sModel.getName());

			StoreModel memoryStore = StoreModel.builder()
			.name(jedis.hget("store-1", "name")).build();
			assertEquals(sModel.getName(),memoryStore.getName());
		}
		catch(Exception e){
			fail("can no connet", e);
		}
	}

}
