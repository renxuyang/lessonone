package com.example.springboot.exception.Service;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;
    private String data;

    public MyEvent(Object source, String data) {
        super(source);
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
