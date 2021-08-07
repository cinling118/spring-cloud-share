package com.cloud.web;


import com.cloud.redis.serivce.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestReids{
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private RedisService redisService;

    @Test
    public void set(){
        redisTemplate.opsForValue().set("myKey","myValue");
        System.out.println(redisTemplate.opsForValue().get("myKey"));
    }

    @Test
    public void test_redisService(){
        redisService.set("myKey_3","myValue_3");
        System.out.println(redisService.get("myKey_3"));
    }
}
