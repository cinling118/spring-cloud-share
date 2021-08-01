package com.cloud.web.service;

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

}
