package com.cloud.service.controller;


import com.cloud.service.entity.User;
import com.cloud.service.service.IUserService;
import com.cloud.service.service.impl.UserServiceImpl;
import com.netflix.discovery.converters.jackson.EurekaXmlJacksonCodec;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @Cacheable(value = "user",key = "#userId") //-- 本地缓存
    @GetMapping("/getUser")
    public User getUser(long userId){
//        StopWatch stopWatch = new StopWatch("查询数据库任务耗时");
//        stopWatch.start("任务一");
        User user = userService.getById(userId);
//        stopWatch.stop();
//        System.err.println(stopWatch.prettyPrint());
        return user;
    }

    @GetMapping("/getUser2")
    public User getUser2(long userId){
        User user = UserServiceImpl.userMap.get(userId);
        if (user == null) {
            user = userService.getById(userId);
            UserServiceImpl.userMap.put(user.getUserId(), user);
        }
        return user;
    }

    @GetMapping("/findAllUser")
    public List<User> findAllUser(){
//        System.out.println("findAllUser for service1");
//        logger.debug("测试logger.debug：访问findAllUser" );
//        logger.info("测试logger.info：访问findAllUser");
//        logger.error("测试logger.error：访问findAllUser" );
//        logger.warn("测试logger.warn：访问findAllUser" );
        return userService.findAllUser();//查询一次数据库，并返回
    }

    @GetMapping("/add")
    public long add(String userName,String pw){
        return userService.add(userName,pw);
    }

    @GetMapping("/test1")
    public String test1() throws Exception {
        userService.findAllUser();//查询一次数据库
        userService.test1();//生产一个3.4M左右的list
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        } finally {
        }
        return "success";
    }

    @GetMapping("/test2")
    public String test2(){
        userService.test2();
        return "success";
    }

    @GetMapping("/test3")
    public List<User> test3() {
        return userService.findAllUser2();//查询一次数据库
    }

    @GetMapping("/test4")
    public String test4(){
        //34M对象
        for (int j = 0; j < 1000000; j++) {
            UserServiceImpl.staticList.add(new String("我是中国人 我为中国骄傲"));
        }
        return UserServiceImpl.staticList.size() + "";
    }

    @GetMapping("/test5")
    public String test5(){
        List<User> userList = userService.findAllUser();
        for (User user : userList) {
            UserServiceImpl.userMap.put(user.getUserId(),user);
        }
        return UserServiceImpl.userMap.size() + "";
    }
}
