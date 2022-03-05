package com.example.springboot.exception.beanpost;


import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RoutingInjected {
    String value() default "BeanPostImpl1";
}
