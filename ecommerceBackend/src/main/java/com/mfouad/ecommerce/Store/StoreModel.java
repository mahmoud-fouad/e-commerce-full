package com.mfouad.ecommerce.Store;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class StoreModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    
    String name;
    String address;
    
}
