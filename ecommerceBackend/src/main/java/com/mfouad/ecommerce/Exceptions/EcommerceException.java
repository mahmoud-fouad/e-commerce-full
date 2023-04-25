package com.mfouad.ecommerce.Exceptions;

import org.springframework.http.HttpStatus;

public class EcommerceException extends RuntimeException {

HttpStatus status;

public EcommerceException(String message){
super(message);
this.status=HttpStatus.BAD_REQUEST;
}

public EcommerceException(String message,HttpStatus status){
super(message);
this.status=status;
}

public HttpStatus getStatus() {
    return status;
}
    
}
