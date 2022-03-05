package com.example.springboot.exception;

import com.example.springboot.exception.map.object.GoodsDO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@SpringBootTest
public class RedisTest {
    @DurationUnit(ChronoUnit.SECONDS)
    Duration heartbeatTime ;

    @Test
    void testRedis(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println(jedis.ping());
        String result = jedis.set("a","1");
        System.out.println(result);
    }

    @Test
    void testTime(){
        heartbeatTime = Duration.ofSeconds(4000);
        System.out.println(heartbeatTime.toMillis());
    }
    @Test
    void testField(){
        try{
            Class clazz = GoodsDO.class;
            System.out.println(clazz);
            Class clazz1 = Class.forName("com.example.springboot.exception.map.object.GoodsDO");
            System.out.println(clazz1);
            Class clazz2 = new GoodsDO().getClass();
            System.out.println(clazz2);
            System.out.println(clazz==clazz1);
            System.out.println(clazz==clazz2);
            System.out.println(clazz1==clazz2);

        }catch (ClassCastException | ClassNotFoundException e){
            e.printStackTrace();
        }




    }
}
