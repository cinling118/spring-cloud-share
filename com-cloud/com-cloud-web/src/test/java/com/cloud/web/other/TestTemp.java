package com.cloud.web.other;

import org.redisson.misc.Hash;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class TestTemp {
    private int num;
    private static int age;

    static int getAge(){
     return age;
    }

    public static void main(String[] args) throws Exception {
        //方式一
//        Class<HashMap> hashMapClass = HashMap.class;
//        Map<Integer,Integer> map = hashMapClass.newInstance();
////        Constructor constructor  = hashMapClass.getConstructor();
////        Map<Integer,Integer> map = (Map<Integer,Integer>)constructor.newInstance();
//        map.put(1,1);
//        map.put(2,2);
//        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
//            System.out.println("k=" + entry.getKey() + ",v=" + entry.getValue());
//        }

        //方式二
//        HashMap<Integer, Integer> map = new HashMap<>();
//        Class<? extends Map> class_2 = map.getClass();
//        Map<Integer,Integer> map2 = class_2.newInstance();
//        map2.put(1,1);
//        map2.put(2,2);
//        for (Map.Entry<Integer,Integer> entry : map2.entrySet()) {
//            System.out.println("k=" + entry.getKey() + ",v=" + entry.getValue());
//        }

        //方式三
//        Class<?> class_3 = Class.forName("java.util.HashMap");
//        Map<Integer,Integer> map3 = (Map<Integer,Integer>)class_3.newInstance();
//        map3.put(1,1);
//        map3.put(2,2);
//        for (Map.Entry<Integer,Integer> entry : map3.entrySet()) {
//            System.out.println("k=" + entry.getKey() + ",v=" + entry.getValue());
//        }

        //方式四
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> class_4 = classLoader.loadClass("java.util.HashMap");
        Map<Integer,Integer> map4= (Map<Integer,Integer>)class_4.newInstance();
        map4.put(1,1);
        map4.put(2,2);
        for (Map.Entry<Integer,Integer> entry : map4.entrySet()) {
            System.out.println("k=" + entry.getKey() + ",v=" + entry.getValue());
        }

        int[] arr = {2,4,5,1,3,7};
        int[] arr2 = Arrays.copyOf(arr,3);
//        for (int i : arr2) {
//            System.out.println(i);
//        }
        int[] arr3 = new int[4];
        System.arraycopy(arr, 0, arr3, 0, 3);
        for (int i : arr3) {
            System.out.println(i);
        }

        AtomicInteger integer = new AtomicInteger(10);
        ReentrantLock lock = new ReentrantLock();
    }
}
