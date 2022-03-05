package com.example.springboot.exception.beanpost;

public class BeanPostImpl1 implements BeanPost{
    @Override
    public void post() {
        System.out.println("Impl1");
    }
}
