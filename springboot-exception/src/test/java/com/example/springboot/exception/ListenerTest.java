package com.example.springboot.exception;

import com.example.springboot.exception.Service.MyEvent;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootTest
public class ListenerTest implements ApplicationContextAware {
    private static Logger logger = LoggerFactory.getLogger(ListenerTest.class);

    private ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Test
    public void listener() {
        context.publishEvent(new MyEvent(this, "测试"));
    }


}
