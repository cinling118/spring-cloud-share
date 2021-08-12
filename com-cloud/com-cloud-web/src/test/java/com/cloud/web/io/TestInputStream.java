package com.cloud.web.io;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestInputStream {

    public static void testClose(int i) {
        try {
            Properties prop = new Properties();
            InputStream in = TestInputStream.class.getResourceAsStream("/test.properties");
            prop.load(in);
            System.out.println(i+":"+prop.get("test.key1"));
            System.out.println(i+":"+prop.get("test.key2"));
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     public static void testNotClose(int i) {
        try {
            Properties prop = new Properties();
            InputStream in = TestInputStream.class.getResourceAsStream("/test.properties");
            prop.load(in);
            System.out.println(i+":"+prop.get("test.key1"));
            System.out.println(i+":"+prop.get("test.key2"));
//            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<10000000;i++) {
            //jps 查看进程
            //查看JVM堆信息：jmap -heap 进程ID
            //统计gc相关信息:jstat -gcutils 进程ID 3s   -- 3s代表每3秒打印一次
            testNotClose(i);
        }
    }
}
