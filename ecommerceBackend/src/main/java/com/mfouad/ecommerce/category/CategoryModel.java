package com.mfouad.ecommerce.category;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@Table(name = "categories")
public class CategoryModel {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private @NotBlank String name;
    private @NotBlank String desc;
    private String imageUrl;
    
}
