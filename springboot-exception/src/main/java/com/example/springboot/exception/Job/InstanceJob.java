package com.example.springboot.exception.Job;

import org.springframework.scheduling.annotation.Scheduled;


public class InstanceJob {

    @Scheduled(cron = " */5 * * * * ? ")
    public void test(){
        System.out.println("rxy");
    }
}
