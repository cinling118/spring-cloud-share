package com.cloud.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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
        String str = "hi service1" + name + ",i am from port:" + port;
        Map<String, Object> map = new HashMap<>();
//        map.put("user",user);
        map.put("str",str);
        return map;
    }

    @RequestMapping("/test1")
    public String test1(){
        List<String> list = new ArrayList<String>();
        //10M的PermSize在integer范围内足够产生OOM了
        int i = 0;
        for (int j = 0; j < 100000; j++) {
            list.add(new String("我是中国人 我为中国骄傲"));
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "1";
//        return "testList大小="+ Arrays.toString(list.toArray()).getBytes().length;//打印占用字节数。;
    }
}
