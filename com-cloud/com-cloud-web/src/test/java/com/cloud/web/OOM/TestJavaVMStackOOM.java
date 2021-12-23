package com.cloud.web.OOM;


import org.apache.commons.collections.bag.SynchronizedSortedBag;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TestJavaVMStackOOM {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        System.out.println("free内存:" + Runtime.getRuntime().freeMemory() / 1024/ 1024);
//        String[] aaa = new String[9000000];
//        for (int i = 0; i < aaa.length; i++) {
//            if (i%1000 == 0) {
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                }
//            }
//            aaa[i] = new String("aaa");
//        }
//        System.out.println("free内存:" + Runtime.getRuntime().freeMemory() / 1024 / 1024);

        String a = "china";
        String b = "我是程序猿，会hello world!我是程序猿，会hello world!我是程序猿，会hello world!ok!";//1KB=1024B=1024byte(字节)=8192bit
        System.out.println(a.getBytes().length);
        System.out.println(b.getBytes().length);
        System.out.println(b.length());

        System.out.println("begin-free内存:" + Runtime.getRuntime().freeMemory() / 1024/ 1024);
        List<String> list = new ArrayList<String>();
        for (int j = 0; j < 100000; j++) {
            list.add(new String("绝对不可能，我本地没有问题！"));
        }
        Field f = ArrayList.class.getDeclaredField("elementData");
        f.setAccessible(true);
        Object[] o = (Object[]) f.get(list);
        String result = "测试RAM结束，测试占用内存空间约为 : " + ((long)o.length * (long)"我是中国人 我为中国骄傲".length() * 3);
        System.out.println(result);
        System.out.println("begin-free内存:" + Runtime.getRuntime().freeMemory() / 1024/ 1024);

//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < 500000; i++) {
//            list.add(new String("aaa"));
//        }
//        for (int i = 0; i < 4; i++) {
//            System.out.println("begin-free内存:" + Runtime.getRuntime().freeMemory() / 1024/ 1024);
//            long startTime=System.currentTimeMillis();
//            int index = list.size();
//            String[] aaa = new String[index];
//            System.out.println("String[]-free内存:" + Runtime.getRuntime().freeMemory() / 1024/ 1024);
//            for (int j = 0; j < index; j++) {
//                String str = new String("aaa" + j);
//                aaa[j] = str;
//                str.intern();
//            }
//            System.out.println("end-free内存:" + Runtime.getRuntime().freeMemory() / 1024/ 1024);
//            long endTime=System.currentTimeMillis();
//            System.out.println("testA运行花费了： "+(endTime-startTime)+"毫秒");
//            System.gc();
//        }
    }

    public static void testA(String[] aaa){
        long startTime=System.currentTimeMillis();
        int length = aaa.length;
        for (int i = 0; i < length; i++) {
            aaa[i] = new String("aaa" + i);
        }
        long endTime=System.currentTimeMillis();
    }

    public static void testB(List<String> list){
        System.out.println("begin-free内存:" + Runtime.getRuntime().freeMemory() / 1024/ 1024);
        long startTime=System.currentTimeMillis();
        int index = list.size();
        String[] aaa = new String[index];
        for (int j = 0; j < index; j++) {
            aaa[j] = new String("aaa" + j);
        }
        long endTime=System.currentTimeMillis();
        System.out.println("testA运行花费了： "+(endTime-startTime)+"毫秒");
        System.out.println("end-free内存:" + Runtime.getRuntime().freeMemory() / 1024/ 1024);
    }
}