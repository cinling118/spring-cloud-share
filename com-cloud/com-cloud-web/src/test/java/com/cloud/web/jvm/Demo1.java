package com.cloud.web.jvm;

/**
 * -Xmn5M -Xms10M -Xmx10M -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=10M -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
 */
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        // 1. 在eden区创建了一个1m数组对象，main线程虚拟机栈中
        System.out.println("-------0---------");
        Thread.sleep(100);
        // 的main()方法栈帧的局部变量arry1指向它
        byte[] arry1 = new byte[1024 * 1024];
        Thread.sleep(100);
        System.out.println("-------1---------");
        // 2. eden区中创建了一个新对象，arry1指向第二个对象
        arry1 = new byte[1024 * 1024];
        Thread.sleep(100);
        System.out.println("-------2---------");
        // 3. eden区中创建了一个新对象，arry1指向第三个对象
        arry1 = new byte[1024 * 1024];
        Thread.sleep(100);
        System.out.println("-------3---------");
        // 4. arry1不指向任何对象，3个对象没有gc root引用，变成了垃圾
        arry1 = null;
        // 5. 往eden区中创建一个2m对象，由于eden区最大只有4m，此时会触发young gc
        byte[] arry2 = new byte[2 * 1024 * 1024];
        Thread.sleep(100);
        System.out.println("-------4---------");
    }
}
