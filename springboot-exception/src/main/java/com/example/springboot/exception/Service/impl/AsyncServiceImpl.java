package com.example.springboot.exception.Service.impl;

import com.example.springboot.exception.Service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class AsyncServiceImpl implements AsyncService {

    private static final Logger log = LoggerFactory.getLogger(AsyncServiceImpl.class);
    @Override
    @Async("asyncExecutor")
    public void executeAsync(CountDownLatch latch) {
        log.info("开始异步执行");
        try{
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }

        latch.countDown();
        log.info("结束异步执行");
    }
}
