package com.cloud.web.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *net.sf.json.JSONArray.fromObject() 效率问题
*/
public class TestJSONArray {

    public static void main(String[] args) {
        TestJSONArray.test();
    }

    public static void test(){
        List<User> list = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId((long) i);
            user.setName("我是程序员" + i);
            user.setAge(i);
            user.setCreateTime(new Date());
            list.add(user);
        }
        long startTime=System.currentTimeMillis();
        net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(list);
        long endTime=System.currentTimeMillis();
        System.out.println("net.sf.json.JSONArray.fromObject()运行花费了： "+(endTime-startTime)+"毫秒");
        long startTime2=System.currentTimeMillis();
        jsonArray.toString();
        long endTime2=System.currentTimeMillis();
        System.out.println("jsonArray.toString()运行花费了： "+(endTime2-startTime2)+"毫秒");
        long startTime3=System.currentTimeMillis();
        com.alibaba.fastjson.JSONObject.toJSONString(list);
        long endTime3=System.currentTimeMillis();
        System.out.println("com.alibaba.fastjson.JSONObject.toJSONString()运行花费了： "+(endTime3-startTime3)+"毫秒");
    }
}
