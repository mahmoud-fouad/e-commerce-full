package com.mfouad.productsList;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

     private boolean success;


    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    public Date getTimeStamp(){
        return new Date();
    }
}