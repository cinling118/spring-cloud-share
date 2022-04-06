package com.cloud.web.json;


import com.alibaba.fastjson.JSON;
import com.cloud.web.utils.JacksonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import net.sf.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestGsonAndFastjon {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 1; i++) {
            objectToJson();//bean序列化json
//        jsonToObject();//json反序列化bean
//        testJackSon();
        }
    }

    /**
     * bean序列化json
    */
    public static void objectToJson() throws Exception {
        User user = new User();
        user.setAge(18);
        user.setId(1001L);
        user.setName("张三");
        user.setCreateTime(new Date());
//        JacksonUtils.toJSONString(user);
        long currTime = System.currentTimeMillis();
        ObjectMapper objectMapper = new ObjectMapper();
        for (int i = 0; i < 10000; i++) {
            objectMapper.writeValueAsString(user);
//            JacksonUtils.toJSONString(user);
        }
        System.out.println("序列化-jackson:"+(System.currentTimeMillis() - currTime));
        currTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            net.sf.json.JSONObject.fromObject(user).toString();
        }
        System.out.println("序列化-json-lib:"+(System.currentTimeMillis() - currTime));
        currTime = System.currentTimeMillis();
        Gson gson = new Gson();
        for (int i = 0; i < 10000; i++) {
            gson.toJson(user);
        }
        System.out.println("序列化-gson:"+(System.currentTimeMillis() - currTime));
        currTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            JSON.toJSONString(user);
        }
        System.out.println("序列化-fastjson:"+(System.currentTimeMillis() - currTime));
    }

    /**
     * json反序列化bean
     */
    public static void jsonToObject() throws Exception{
        String userStr_jackjson = "{\"createTime\":1640143972425,\"name\":\"张三\",\"age\":18,\"id\":1001}";
        long currTime = System.currentTimeMillis();
        ObjectMapper objectMapper = new ObjectMapper();
        for (int i = 0; i < 10000; i++) {
            objectMapper.readValue(userStr_jackjson, User.class);
        }
        System.out.println("反序列化-jackson:"+(System.currentTimeMillis() - currTime));
        String userStr_jsonLib = "{\"name\":\"张三\",\"id\":1001,\"age\":18}";
        currTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            JSONObject.toBean(JSONObject.fromObject(userStr_jsonLib), User.class);
        }
        System.out.println("反序列化-json-lib:"+(System.currentTimeMillis() - currTime));
        String userStr_json = "{\"createTime\":\"Dec 22, 2021 11:02:58 AM\",\"name\":\"张三\",\"age\":18,\"id\":1001}";
        currTime = System.currentTimeMillis();
        Gson gson = new Gson();
        for (int i = 0; i < 10000; i++) {
            gson.fromJson(userStr_json, User.class);
        }
        System.out.println("反序列化-gson:"+(System.currentTimeMillis() - currTime));
        String userStr_fastjson = "{\"age\":18,\"createTime\":1640142424816,\"id\":1001,\"name\":\"张三\"}";
        currTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            JSON.parseObject(userStr_fastjson, User.class);
        }
        System.out.println("反序列化-fastjson:"+(System.currentTimeMillis() - currTime));
    }

    /**
     * null字段过滤，不返回测试
    */
    public static void testfilterNull() {
        User user = new User();
        user.setAge(18);
        user.setId(1001L);
        user.setName(null);
        user.setCreateTime(null);
        Gson gson = new Gson();
        System.out.println("gson:" + gson.toJson(user));
        System.out.println("fastjon:" +  JSON.toJSONString(user));
    }

    public static void testJackSon(){
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
//            User user = new User();
//            user.setAge(18);
//            user.setId(1001L);
//            user.setName("张三");
//            user.setCreateTime(new Date());
//            map.put("k" + i, user);
            map.put("k" + i, "程序员" + i + "");
        }
        long currTime = System.currentTimeMillis();
        net.sf.json.JSONObject.fromObject(map).toString();
        System.out.println("json-lib:"+(System.currentTimeMillis() - currTime));
        currTime = System.currentTimeMillis();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
        }
        System.out.println("jackson:"+(System.currentTimeMillis() - currTime));
        currTime = System.currentTimeMillis();
        Gson gson = new Gson();
        gson.toJson(map);
        System.out.println("gson:"+(System.currentTimeMillis() - currTime));
        currTime = System.currentTimeMillis();
        com.alibaba.fastjson.JSONObject.toJSONString(map);
        System.out.println("fastjson:"+(System.currentTimeMillis() - currTime));

    }
}
