package com.example.springboot.exception.controller;

import com.example.springboot.exception.Service.AsyncService;
import com.example.springboot.exception.Service.ExceptionHandlerService;
import com.example.springboot.exception.properties.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

@Controller
public class ExceptionController {

    @Autowired
    AsyncService asyncService;

    ExceptionHandlerService exceptionHandlerService;
    HelloProperties helloProperties;
    public ExceptionController( ExceptionHandlerService exceptionHandlerService, HelloProperties helloProperties){
        this.exceptionHandlerService = exceptionHandlerService;
        this.helloProperties = helloProperties;
    }
    @RequestMapping(value = "/api/exception",method = RequestMethod.GET)
    public void testException(){
        exceptionHandlerService.handler();
        Map<Integer,Integer> map = new HashMap<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            System.out.println(entry);
        }
    }


    @RequestMapping(value = "config",method = RequestMethod.GET)
    public Object testConfig(){
        return helloProperties.getName();
    }

    @RequestMapping(value = "async",method = RequestMethod.GET)
    public Object testAsync() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0;i<50;i++){
            asyncService.executeAsync(latch);
        }
        latch.await();
        return helloProperties.getName();
    }

}
