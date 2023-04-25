package com.mfouad.ecommerce.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mfouad.ecommerce.Responses.ErrorResponse;

@ControllerAdvice
public class EcommerceExceptionHandler extends ResponseEntityExceptionHandler {
    
@ExceptionHandler({EcommerceException.class})
public ResponseEntity<ErrorResponse> handleException(EcommerceException ex){

return new ResponseEntity<ErrorResponse>(ErrorResponse.builder().success(false).message(ex.getMessage()).build(), ex.getStatus());

}

}
