package com.cloud.service.controller;


import com.cloud.service.entity.User;
import com.cloud.service.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author zhiyun.chen
 * @since 2021-08-01
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/getUser")
    public User getUser(){
        return userService.getById(10000);
    }

    @GetMapping("/findAllUser")
    public List<User> findAllUser(){
        System.out.println("findAllUser for service1");
        return userService.findAllUser();
    }

    @GetMapping("/test1")
    public String test1(){
        userService.findAllUser();
        userService.test1();
        return "success";
    }
}
