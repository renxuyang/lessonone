package com.example.springboot.exception.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "alarm")
public class HelloProperties {
    private String aso = "msg";
    public String getName() {
        return this.aso;
    }
    public void setName(String name) {
        this.aso = name;
    }


}
