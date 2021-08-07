package com.cloud.web.controller;

import com.cloud.redis.serivce.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class ReidsController {
    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/set")
    public String set(String key, String value){
        redisService.set(key,value);
        return "redis添加成功：key:" + key + ",value:" + value;
    }

    @RequestMapping(value = "/get")
    public String get(String key){
        Object value = redisService.get(key);
        return value == null?"not find key":value.toString();
    }
}
