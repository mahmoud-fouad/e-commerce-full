package com.mfouad.ecommerce.Responses;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ApiResponse {

    private boolean success;


    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    public Date getTimeStamp(){
        return new Date();
    }

    

}
