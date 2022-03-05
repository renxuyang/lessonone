package com.example.springboot.exception.Service.impl;

import com.example.springboot.exception.MyException;
import com.example.springboot.exception.MyExceptionEnum;
import com.example.springboot.exception.Service.ExceptionHandlerService;
import org.springframework.stereotype.Service;

@Service
public class ExceptionHandlerImpl implements ExceptionHandlerService {

    @Override
    public void handler() {
        System.out.println(123);
        throw new MyException(MyExceptionEnum.VALIDATE_ERROR);
    }
}
