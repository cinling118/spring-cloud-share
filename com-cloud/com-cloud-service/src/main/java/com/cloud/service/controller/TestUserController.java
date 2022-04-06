package com.cloud.service.controller;


import com.cloud.service.entity.User;
import com.cloud.service.service.IUserService;
import com.cloud.service.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author zhiyun.chen
 * @since 201-08-01
 */
@RestController
@RequestMapping("/user")
public class TestUserController {
    private final static Logger logger = LoggerFactory.getLogger(TestUserController.class);

    @Autowired
    private IUserService userService;

    /**
     * 循环insert
    */
    @GetMapping("/forInsert")
    public String forInsert(){
        List<User> userList = new ArrayList<>();
        for (long i = 40001;i<=40500;i++) {
            User user = new User();
            user.setUserId(i);
            user.setUserName("李四" + i);
            user.setUserPass("123");
            user.setUserDate(new Date());
            userList.add(user);
        }
        userService.forInsert(userList);
        return "success";
    }

    /**
     * 批量insert
     */
    @GetMapping("/batchInsert")
    public String batchInsert(){
        List<User> userList = new ArrayList<>();
        for (long i = 40001;i<=40500;i++) {
            User user = new User();
            user.setUserId(i);
            user.setUserName("李四" + i);
            user.setUserPass("123");
            user.setUserDate(new Date());
            userList.add(user);
        }
        userService.batchInsert(userList);
        return "success";
    }

    /**
     * 循环update
     */
    @GetMapping("/forUpdate")
    public String forUpdate(){
        List<Long> userIdList = new ArrayList<>();
        for (long i = 40001;i<=40500;i++) {
            userIdList.add(i);
        }
        List<User> userList = userService.selectByIdList(userIdList);
        for (User user : userList) {
            user.setUserName("张三");
            user.setUserPass("666");
        }
        userService.forUpdate(userList);
        return "success";
    }

    /**
     * 批量update
     */
    @GetMapping("/batchUpdate")
    public String batchUpdate(){
        List<Long> userIdList = new ArrayList<>();
        for (long i = 40001;i<=40500;i++) {
            userIdList.add(i);
        }
        List<User> userList = userService.selectByIdList(userIdList);
        for (User user : userList) {
            user.setUserName("张三");
            user.setUserPass("666");
        }
        userService.batchUpdate(userList);
        return "success";
    }

    /**
     * 批量删除
    */
    @GetMapping("/deleteByIdList")
    public String deleteByIdList(){
        List<Long> userIdList = new ArrayList<>();
        for (long i = 40001;i<=40500;i++) {
            userIdList.add(i);
        }
        userService.deleteByIdList(userIdList);
        return "success";
    }

    /**
     * 循环查询
     */
    @GetMapping("/forSelect")
    public List<User> forSelect(){
        List<Long> userIdList = new ArrayList<>();
        for (long i = 40001;i<=40500;i++) {
            userIdList.add(i);
        }
        return userService.forSelect(userIdList);
    }


    /**
     * 批量查询
     */
    @GetMapping("/selectByIdList")
    public List<User> selectByIdList(){
        List<Long> userIdList = new ArrayList<>();
        for (long i = 40001;i<=40500;i++) {
            userIdList.add(i);
        }
        return userService.selectByIdList(userIdList);
    }

    @GetMapping("/test11")
    public List<User> test11() {
        return userService.test11();
    }

    @GetMapping("/test22")
    public List<User> test22() {
        return userService.test22();
    }
}
