package com.example.springboot.exception;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum MyExceptionEnum {
    NOT_FOUND(600001,"无法找到相关信息"),
    VALIDATE_ERROR(60002,"失败");
    private static Map<Integer,MyExceptionEnum> map = new HashMap<>();
    static {
        EnumSet<MyExceptionEnum> set = EnumSet.allOf(MyExceptionEnum.class);
         set.forEach(myExceptionEnum -> map.put(myExceptionEnum.getCode(),myExceptionEnum));
    }

    private int code;
    private String msg;
    MyExceptionEnum(int code, String msg){
        this.code = code;
        this.msg = msg;

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
