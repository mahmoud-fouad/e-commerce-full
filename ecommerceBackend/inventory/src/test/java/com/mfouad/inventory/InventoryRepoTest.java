package com.mfouad.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest

public class InventoryRepoTest {

    @Autowired
    InventoryRepo repo;

    @BeforeEach
    public  void loadData(){
      List<InvProduct>prods=  IntStream.range(1, 5).mapToObj(
            i-> InvProduct.builder().categoryDesc("desc"+i)
            .categoryID(i)
            .categoryName("cat name"+i)
            .description("desc"+i)
            .id(i)
            .invCount(4)
            .manufacturer("manf"+i)
            .name("name"+i)
            .prodUniName("produniName"+i)
            .build()
            ).collect(Collectors.toList());
            prods.forEach(repo::save);

    }

    @Test
    public void prodsUniNameCount(){
        List<Object[]> result = repo.prodsUniNameCount(Arrays.asList("produniName1","produniName2"));
        assertTrue(result.size()==2);
assertEquals("produniName1", result.get(0)[0]);
assertEquals(4, result.get(0)[1]);
    }
    
}
