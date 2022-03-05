package com.example.springboot.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyExceptionRes {
    private int code;
    private String msg;
    private Long timStamp;
    public MyExceptionRes(MyExceptionEnum exceptionEnum){
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMsg();
        this.timStamp = System.currentTimeMillis();

    }

}
