package com.cloud.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HiServiceController {
//    @Autowired
//    private UserService userService;

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam String name)
    {
        return "hi " + name + ",i am from port:" + port;
    }

    @RequestMapping("/getUser")
    public Object getUser(@RequestParam String name)
    {
//        User user = new User();
//        user.setUserId(111L);
//        user.setUserName("王五");
        String str = "hi service2" + name + ",i am from port:" + port;
        Map<String, Object> map = new HashMap<>();
//        map.put("user",user);
        map.put("str",str);
        return map;
    }
}
