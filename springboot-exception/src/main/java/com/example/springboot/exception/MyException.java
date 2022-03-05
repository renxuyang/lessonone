package com.example.springboot.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class MyException extends RuntimeException{
    private MyExceptionEnum exceptionEnum;
    private String msg;
    private int code;

    public MyException(MyExceptionEnum exceptionEnum){
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMsg();
    }
    public MyException(int code,String msg){
        this.msg = msg;
        this.code = code;
    }
    public MyException(MyExceptionEnum myExceptionEnum,String msg){
        this.code = myExceptionEnum.getCode();
        this.msg = msg;
    }

}
