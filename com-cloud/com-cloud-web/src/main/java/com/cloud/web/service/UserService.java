package com.cloud.web.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.cloud.web.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {
    @Autowired
    RestTemplate restTemplate;

    public List<User> listUser() {
        ResponseEntity<Object> entity = restTemplate.getForEntity("http://COM-CLOUD-GATEWAY/user/findAllUser", Object.class);
        return (List<User>) entity.getBody();
    }

    public User getUser(long userId) {
        ResponseEntity<Object> entity = restTemplate.getForEntity("http://COM-CLOUD-GATEWAY/user/getUser?userId=" + userId, Object.class);
        String json = JSONObject.toJSONString(entity.getBody());
        return JSONObject.parseObject(json, User.class);
    }
}
