package com.mfouad.productsManagment;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor

public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    String description;
    String manufacturer;
    @Column(unique = true)
    String prodUniName;
    double price;

    @JsonIgnore
    @Column(name ="category_id")
    long categoryID;

public String getProdUniName(){
    if (prodUniName==null)
    prodUniName =manufacturer+"-"+name+new Date().getTime();

    return prodUniName;
}


}