package com.cloud.web.design.singleton;

/**
 * 懒汉式
 */
public class Singleton1 {
    private static Singleton1 singleton1 = null;

    private Singleton1(){};

    public synchronized static Singleton1 getInstance(){
        if (null == null) {
            singleton1 = new Singleton1();
        }
        return singleton1;
    }
}
