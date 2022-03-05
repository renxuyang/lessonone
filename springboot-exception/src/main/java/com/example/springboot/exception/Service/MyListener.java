package com.example.springboot.exception.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener {
    private static  final Logger log = LoggerFactory.getLogger(MyListener.class);

    @EventListener
    public void testListerner(MyEvent event){
        log.info(event.getSource()+":"+event.getData());
    }
}
