package com.mfouad.productsManagment.commands;

import com.mfouad.productsManagment.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductCommand {

    ProductDTO dto;
}
