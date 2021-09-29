package com.cloud.service.controller;


import com.cloud.service.entity.User;
import com.cloud.service.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.util.StopWatch;
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

//    @Cacheable(value = "user",key = "#userId") -- 本地缓存
    @GetMapping("/getUser")
    public User getUser(long userId){
//        StopWatch stopWatch = new StopWatch("查询数据库任务耗时");
//        stopWatch.start("任务一");
        User user = userService.getById(userId);
//        stopWatch.stop();
//        System.err.println(stopWatch.prettyPrint());
        return user;
    }

    @GetMapping("/findAllUser")
    public List<User> findAllUser(){
        System.out.println("findAllUser for service1");
        return userService.findAllUser();//查询一次数据库，并返回
    }

    @GetMapping("/add")
    public long add(String userName,String pw){
        return userService.add(userName,pw);
    }

    @GetMapping("/test1")
    public String test1(){
        userService.findAllUser();//查询一次数据库
        userService.test1();//生产一个3.4M左右的list
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//        }
        return "success";
    }

    @GetMapping("/test2")
    public String test2(){
        userService.test2();//做1万次运算
        return "success";
    }
}
