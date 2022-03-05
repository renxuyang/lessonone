//package com.example.springboot.exception.beanpost;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.stereotype.Component;
//
//@Component
//public class HelloServiceTest {
//
//    @RoutingInjected(value = "helloServiceImpl2")
//    private BeanPost helloService;
//
//    public void testSayHello() {
//        helloService.post();
//    }
//
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.example.springboot.exception.beanpost");
//        HelloServiceTest helloServiceTest = applicationContext.getBean(HelloServiceTest.class);
//        helloServiceTest.testSayHello();
//    }
//    }
