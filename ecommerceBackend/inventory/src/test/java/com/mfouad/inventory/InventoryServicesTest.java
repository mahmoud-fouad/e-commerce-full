package com.mfouad.inventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mfouad.dto.ProductInvDto;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.stream.Collectors;

import java.util.List;
import java.util.stream.IntStream;

@ExtendWith(MockitoExtension.class)
public class InventoryServicesTest {

    @Mock
    InventoryRepo repo;

     @InjectMocks
    InventoryServices services;

    List<String> productsUniNameData;
    List<ProductInvDto> responseData;

    @BeforeEach
    void setData(){
productsUniNameData = IntStream.range(1, 5).mapToObj(
    i->"produniName"+i).collect(Collectors.toList());

    List<Object[]> result=  IntStream.range(1, 5).mapToObj(
        i-> {return new Object[]{"produniName"+i , i-1};
       
}).collect(Collectors.toList());


responseData =IntStream.range(1, 5).mapToObj(
     i->ProductInvDto.builder().prodUniName("produniName"+i)
     .available((i-1)>0)
     .build()).collect(Collectors.toList());

    when(repo.prodsUniNameCount(productsUniNameData)).thenReturn(result);
    }

    @Test
    public void isProdsAvailableInInvTest(){
        try{
        assertArrayEquals(responseData.toArray(), services.isProdsAvailableInInv(productsUniNameData).toArray()); 
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    
}
