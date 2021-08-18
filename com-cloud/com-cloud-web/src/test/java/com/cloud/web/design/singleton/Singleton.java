package com.cloud.web.design.singleton;

/**
 *双重检查模式
 * https://www.cnblogs.com/xz816111/p/8470048.html
*/
public class Singleton {
    private volatile static Singleton singleton;//volatile 禁止指令重排

    private Singleton(){}

    public static Singleton getInstance() {
        if (singleton== null) {
            synchronized (Singleton.class) {
                if (singleton== null) {
                    singleton= new Singleton();
                }
            }
        }
        return singleton;
    }
}