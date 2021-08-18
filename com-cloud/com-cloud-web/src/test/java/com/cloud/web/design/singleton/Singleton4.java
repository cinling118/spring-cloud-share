package com.cloud.web.design.singleton;

/**
 * 静态内部类单例模式
 */
public class Singleton4 {
    private Singleton4(){
    }
    private static class Inner{
        private static final Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance(){
        return Inner.instance;
    }

//    public static Singleton4 getInstance(){
//        return Inner.instance;
//    }
//    private static class Inner {
//        private static final Singleton4 instance = new Singleton4();
//    }
}
