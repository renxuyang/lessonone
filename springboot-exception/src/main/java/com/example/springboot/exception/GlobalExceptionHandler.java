package com.example.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {MyException.class})
    public ResponseEntity<MyExceptionRes> parseException(MyException e, HttpServletRequest request){
       MyExceptionEnum em = e.getExceptionEnum();
        return ResponseEntity.status(HttpStatus.OK).body(new MyExceptionRes(em));
    }

}
